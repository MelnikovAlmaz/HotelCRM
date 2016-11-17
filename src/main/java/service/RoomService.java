package service;

import entity.Room;

import java.sql.Date;
import java.util.List;

public interface RoomService {
    Room findRoomById(Integer id);
    List<Room> findAllRooms();
    void save(Room room);
    void delete(Room room);
    List<Room> findAllRoomsByHotelId(Integer hotelId);
    Room findFreeRoomForRoomCategory(Integer roomCategoryId);
    Integer findRoomOrderedDays(Room room, Date beginDate, Date endDate);
}
