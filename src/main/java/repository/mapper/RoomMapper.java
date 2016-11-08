package repository.mapper;

import entity.Hotel;
import entity.Room;
import entity.RoomCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import repository.HotelRepository;
import repository.RoomCategoryRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomMapper implements RowMapper<Room> {
    @Autowired
    RoomCategoryRepository roomCategoryRepository;
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Room mapRow(ResultSet resultSet, int i) throws SQLException {
        Room room = new Room();
        room.setId(resultSet.getInt("id"));
        room.setNumber(resultSet.getInt("number"));
        room.setAvailable(resultSet.getBoolean("isAvailable"));
        room.setCleaned(resultSet.getBoolean("isCleaned"));
        RoomCategory roomCategory = roomCategoryRepository.findRoomCategoryById(resultSet.getInt("roomCategoryId"));
        room.setCategory(roomCategory);
        Hotel hotel = hotelRepository.findHotelById(resultSet.getInt("hotelId"));
        room.setHotel(hotel);
        return room;
    }
}
