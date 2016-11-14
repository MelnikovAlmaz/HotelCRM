package service.impl;

import entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RoomRepository;
import service.RoomService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room findRoomById(Integer id) {
        Room room = roomRepository.findRoomById(id);
        return room;
    }

    @Override
    public List<Room> findAllRooms() {
        List<Room> rooms = roomRepository.findAllRooms();
        return rooms;
    }

    @Override
    public void save(Room room) {
        if(room.getId() == null){
            roomRepository.create(room.getNumber(), room.getHotel(), room.getCategory());
        }
        else {
            roomRepository.update(room.getId(), room.getNumber(), room.getCleaned(), room.getAvailable(), room.getHotel(), room.getCategory());
        }
    }

    @Override
    public void delete(Room room) {
        roomRepository.delete(room.getId());
    }

    @Override
    public List<Room> findAllRoomsByHotelId(Integer hotelId) {
        List<Room> rooms = findAllRooms();
        List<Room> roomsByHotelId = new LinkedList<>();
        for (Room room : rooms) {
            if (room.getHotel().getId() == hotelId) {
                roomsByHotelId.add(room);
            }
        }
        return roomsByHotelId;
    }

    @Override
    public Room findFreeRoomForRoomCategory(Integer roomCategoryId) {
        Room freeRoom = null;
        List<Room> rooms = roomRepository.findAllRoomsByCategoryId(roomCategoryId);
        for (Room room: rooms){
            if(room.getAvailable()) {
                freeRoom = room;
                break;
            }
        }
        return freeRoom;
    }
}
