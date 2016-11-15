package service.impl;

import entity.RoomCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RoomCategoryRepository;
import service.RoomCategoryService;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {
    @Autowired
    private RoomCategoryRepository roomCategoryRepository;

    @Override
    public RoomCategory findRoomCategoryById(Integer id) {
        RoomCategory roomCategory = roomCategoryRepository.findRoomCategoryById(id);
        return roomCategory;
    }

    @Override
    public List<RoomCategory> findAllRoomCategories() {
        List<RoomCategory> roomCategories = roomCategoryRepository.findAllRoomCategories();
        return roomCategories;
    }

    @Override
    public void save(RoomCategory roomCategory) {
        if(roomCategory.getId() == null){
            roomCategoryRepository.create(roomCategory.getName(), roomCategory.getBeds(), roomCategory.getPrice(), roomCategory.getDescription(), roomCategory.getHotel());
        }
        else {
            roomCategoryRepository.update(roomCategory.getId(), roomCategory.getName(), roomCategory.getBeds(), roomCategory.getPrice(), roomCategory.getDescription(), roomCategory.getHotel());
        }
    }

    @Override
    public void delete(RoomCategory roomCategory) {
        roomCategoryRepository.delete(roomCategory.getId());
    }

    @Override
    public List<RoomCategory> findAllRoomCategoriesByHotelId(Integer hotelId) {
        List<RoomCategory> roomCategories = findAllRoomCategories();
        List<RoomCategory> roomCategoriesByHotelId = new LinkedList<>();
        for (RoomCategory roomCategory: roomCategories){
            if (roomCategory.getHotel().getId() == hotelId){
                roomCategoriesByHotelId.add(roomCategory);
            }
        }
        return roomCategoriesByHotelId;
    }

    @Override
    public List<RoomCategory> findAvailableRoomCategoriesByHotelIdInPeriod(Integer hotelId, Date startDate, Date finishDate) {
        List<RoomCategory> roomCategories = roomCategoryRepository.findAvailableRoomCategoriesByHotelIdInPeriod(hotelId, startDate, finishDate);
        return roomCategories;
    }
}
