package repository.impl;

import entity.Hotel;
import entity.Room;
import entity.RoomCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.RoomRepository;
import repository.mapper.RoomMapper;

import java.util.List;

@Repository
public class RoomRepositoryImpl implements RoomRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Room findRoomById(Integer id) {
        String SQL = "SELECT * FROM Room WHERE id = ?";
        Room room = jdbcTemplate.queryForObject(SQL, new Object[]{id}, roomMapper);
        return room;
    }

    @Override
    public void create(Integer number, Boolean isCleaned, Boolean isAvailable, Hotel hotel, RoomCategory category) {
        String SQL = "INSERT INTO Room (number, isCleaned, isAvailable, hotelId, categoryId) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, number, isCleaned, isAvailable, hotel.getId(), category.getId());
    }

    @Override
    public void update(Integer id, Integer number, Boolean isCleaned, Boolean isAvailable, Hotel hotel, RoomCategory category) {
        String SQL = "UPDATE Room SET number = ?, isCleaned = ?, isAvailable = ?, hotelId = ?, categoryId = ? WHERE id = ?";
        jdbcTemplate.update(SQL, number, isCleaned, isAvailable, hotel.getId(), category.getId(), id);
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM Room WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public List<Room> findAllRooms() {
        String SQL = "SELECT * FROM Room ORDER BY number ASC";
        List<Room> rooms = jdbcTemplate.query(SQL, roomMapper);
        return rooms;
    }
}
