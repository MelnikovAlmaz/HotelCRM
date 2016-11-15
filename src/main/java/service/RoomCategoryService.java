package service;

import entity.RoomCategory;

import java.sql.Date;
import java.util.List;

public interface RoomCategoryService {
    RoomCategory findRoomCategoryById(Integer id);
    List<RoomCategory> findAllRoomCategories();
    void save(RoomCategory roomCategory);
    void delete(RoomCategory roomCategory);

    List<RoomCategory> findAllRoomCategoriesByHotelId(Integer hotelId);

    List<RoomCategory> findAvailableRoomCategoriesByHotelIdInPeriod(Integer hotelId, Date startDate, Date finishDate);
}
