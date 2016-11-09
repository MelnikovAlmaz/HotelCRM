package service;

import entity.RoomCategory;

import java.util.List;

public interface RoomCategoryService {
    RoomCategory findRoomCategoryById(Integer id);
    List<RoomCategory> findAllRoomCategories();
    void save(RoomCategory roomCategory);
    void delete(RoomCategory roomCategory);
}
