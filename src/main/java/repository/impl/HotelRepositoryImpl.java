package repository.impl;

import entity.City;
import entity.Employee;
import entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.HotelRepository;
import repository.mapper.HotelInfoMapper;
import repository.mapper.HotelMapper;
import repository.model.HotelInfo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public class HotelRepositoryImpl implements HotelRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public Hotel findHotelById(Integer id) {
        String SQL = "SELECT * FROM Hotel WHERE id = ?";
        Hotel hotel = jdbcTemplate.queryForObject(SQL, new Object[]{id}, hotelMapper);
        return hotel;
    }

    @Override
    public List<Hotel> findAllHotels() {
        String SQL = "SELECT * FROM Hotel";
        List<Hotel> hotels = jdbcTemplate.query(SQL, hotelMapper);
        return hotels;
    }

    @Override
    public void create(String name, String phoneNumber, String address, String description, Employee employee, City city, String imageURL) {
        String SQL = "INSERT INTO Hotel (name, phoneNumber, address, description, managerId, cityId, imageURL) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update( SQL, name, phoneNumber, address, description, employee.getId(), city.getId(), imageURL);
    }

    @Override
    public void update(Integer id, String name, String phoneNumber, String address, String description, Employee employee, City city, String imageURL) {
        String SQL = "UPDATE Hotel SET name = ?, phoneNumber = ?, address = ?, description = ?, managerId = ?, cityId = ?, imageURL = ? WHERE id = ?";
        jdbcTemplate.update( SQL, name, phoneNumber, address, description, employee.getId(), city.getId(), imageURL, id);
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM Hotel WHERE id = ?";
        jdbcTemplate.update( SQL, id);
    }

    @Override
    public List<Hotel> findHotelsByName(String name) {
        name = "%" + name + "%";
        String SQL = "SELECT * FROM Hotel WHERE name LIKE ?";
        List<Hotel> hotels = jdbcTemplate.query(SQL, new Object[]{name}, hotelMapper);
        return hotels;
    }

    @Override
    public List<HotelInfo> findHotelInfo(String name, LocalDate beginDate, LocalDate endDate, Integer guestNumber) {
        name = "%" + name + "%";
        String SQL = "SELECT * FROM search_hotels(?, ?, ?, ?)";
        Object[] data = new Object[]{name, Date.valueOf(beginDate), Date.valueOf(endDate), guestNumber};
        List<HotelInfo> hotelsInfo = jdbcTemplate.query(SQL, data, new HotelInfoMapper());
        return hotelsInfo;
    }

    @Override
    public List<Hotel> findHotelsByManagerId(Integer managerId) {
        String SQL = "SELECT * FROM Hotel WHERE managerId = ? ORDER BY NAME ASC ";
        List<Hotel> hotels = jdbcTemplate.query(SQL, new Object[]{managerId}, hotelMapper);
        return hotels;
    }
}
