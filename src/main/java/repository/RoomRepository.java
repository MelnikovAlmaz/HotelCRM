package repository;

import entity.Hotel;
import entity.Room;
import entity.RoomCategory;

import java.sql.Date;
import java.util.List;

public interface RoomRepository {
    Room findRoomById(Integer id);
    void create(Integer number, Hotel hotel, RoomCategory category);
    void update(Integer id, Integer number, Boolean isCleaned, Boolean isAvailable, Hotel hotel, RoomCategory category);
    void delete(Integer id);
    List<Room> findAllRooms();

    List<Room> findAllRoomsByCategoryId(Integer roomCategoryId);

    Integer findRoomOrderedDays(Integer id, Date beginDate, Date endDate);
}
