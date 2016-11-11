package service;

import entity.Room;

import java.util.List;

public interface RoomService {
    Room findRoomById(Integer id);
    List<Room> findAllRooms();
    void save(Room room);
    void delete(Room room);

    List<Room> findAllRoomsByHotelId(Integer hotelId);
}
