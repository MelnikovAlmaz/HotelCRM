package repository;

import entity.Hotel;
import entity.RoomCategory;

import java.sql.Date;
import java.util.List;

public interface RoomCategoryRepository {
    RoomCategory findRoomCategoryById(Integer id);
    void create(String name, Integer beds, Double price, String description, Hotel hotel);
    void update(Integer id, String name, Integer beds, Double price, String description, Hotel hotel);
    void delete(Integer id);
    List<RoomCategory> findAllRoomCategories();

    List<RoomCategory> findAvailableRoomCategoriesByHotelIdInPeriod(Integer hotelId, Date startDate, Date finishDate);
}
