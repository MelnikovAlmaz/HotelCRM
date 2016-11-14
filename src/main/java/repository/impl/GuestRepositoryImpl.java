package repository.impl;

import entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.GuestRepository;
import repository.mapper.GuestMapper;

import java.util.List;

@Repository
public class GuestRepositoryImpl implements GuestRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private GuestMapper guestMapper;

    @Override
    public Guest findGuestById(Integer id) {
        String SQL = "SELECT * FROM Guest WHERE id = ?";
        Guest guest = jdbcTemplate.queryForObject(SQL, new Object[]{id}, guestMapper);
        return guest;
    }

    @Override
    public List<Guest> findAllGuests() {
        String SQL = "SELECT * FROM Guest ORDER BY id ASC";
        List<Guest> guests = jdbcTemplate.query(SQL, guestMapper);
        return guests;
    }

    @Override
    public void create(String name, String phoneNumber, String passport, String password) {
        String SQL = "INSERT INTO Guest (name, phoneNumber, passport, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update( SQL, name, phoneNumber, passport, password);
    }

    @Override
    public void update(Integer id, String name, String phoneNumber, String passport, String password) {
        String SQL = "UPDATE Guest SET name = ?, phoneNumber = ?, passport = ?, password = ? WHERE id = ?";
        jdbcTemplate.update( SQL, name, phoneNumber, passport, password, id);
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM Guest WHERE id = ?";
        jdbcTemplate.update( SQL, id);
    }

    @Override
    public Guest findGuestByPhoneNumber(String phoneNumber) {
        String SQL = "SELECT * FROM Guest WHERE phoneNumber = ?";
        Guest guest = jdbcTemplate.queryForObject(SQL, new Object[]{phoneNumber}, guestMapper);
        return guest;
    }
}
