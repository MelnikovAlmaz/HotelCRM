package repository.impl;

import entity.Hotel;
import entity.RoomCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.RoomCategoryRepository;
import repository.mapper.RoomCategoryMapper;

import java.util.List;

@Repository
public class RoomCategoryRepositoryImpl implements RoomCategoryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RoomCategoryMapper roomCategoryMapper;

    @Override
    public RoomCategory findRoomCategoryById(Integer id) {
        String SQL = "SELECT * FROM RoomCategory WHERE id = ?";
        RoomCategory city = jdbcTemplate.queryForObject(SQL, new Object[]{id}, roomCategoryMapper);
        return city;
    }

    @Override
    public void create(String name, Integer beds, Double price, String description, Hotel hotel) {
        String SQL = "INSERT INTO RoomCategory (name, beds, price, description, hotelId) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, name, beds, price, description, hotel.getId());
    }

    @Override
    public void update(Integer id, String name, Integer beds, Double price, String description, Hotel hotel) {
        String SQL = "UPDATE RoomCategory SET name = ?, beds = ?, price = ?, description = ?, hotelId = ? WHERE id = ?";
        jdbcTemplate.update(SQL, name, beds, price, description, hotel.getId(), id);
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM RoomCategory WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public List<RoomCategory> findAllRoomCategories() {
        String SQL = "SELECT * FROM RoomCategory ORDER BY beds ASC";
        List<RoomCategory> roomCategories = jdbcTemplate.query(SQL, roomCategoryMapper);
        return roomCategories;
    }
}
