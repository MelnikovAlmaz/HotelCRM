package repository.impl;

import entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.HotelRepository;
import repository.mapper.HotelMapper;

import java.util.List;

@Repository
public class HotelRepositoryImpl implements HotelRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Hotel findHotelById(Integer id) {
        String SQL = "SELECT * FROM Hotel WHERE id = ?";
        Hotel hotel = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new HotelMapper());
        return hotel;
    }

    @Override
    public List<Hotel> findAllHotels() {
        String SQL = "SELECT * FROM Hotel";
        List<Hotel> hotels = jdbcTemplate.query(SQL, new HotelMapper());
        return hotels;
    }

    @Override
    public void create(String name, String phoneNumber, String address, String description) {
        String SQL = "INSERT INTO Hotel (name, phoneNumber, address, description) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update( SQL, name, phoneNumber, address, description);
    }

    @Override
    public void update(Integer id, String name, String phoneNumber, String address, String description) {
        String SQL = "UPDATE Hotel SET name = ?, phoneNumber = ?, address = ?, description = ? WHERE id = ?";
        jdbcTemplate.update( SQL, name, phoneNumber, address, description, id);
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM Hotel WHERE id = ?";
        jdbcTemplate.update( SQL, id);
    }
}
