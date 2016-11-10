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
    public void create(String firstName, String lastName, String phoneNumber, String password) {
        String SQL = "INSERT INTO Guest (firstName, lastName, phoneNumber, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update( SQL, firstName, lastName, phoneNumber, password);
    }

    @Override
    public void update(Integer id, String firstName, String lastName, String phoneNumber, String password) {
        String SQL = "UPDATE Guest SET firstName = ?, lastName = ?, phoneNumber = ? password = ? WHERE id = ?";
        jdbcTemplate.update( SQL, firstName, lastName, phoneNumber, password, id);
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM Guest WHERE id = ?";
        jdbcTemplate.update( SQL, id);
    }
}
