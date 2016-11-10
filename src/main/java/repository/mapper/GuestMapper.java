package repository.mapper;

import entity.Guest;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GuestMapper implements RowMapper<Guest>{
    @Override
    public Guest mapRow(ResultSet resultSet, int i) throws SQLException {
        Guest guest = new Guest();
        guest.setId(resultSet.getInt("id"));
        guest.setName(resultSet.getString("name"));
        guest.setPhoneNumber(resultSet.getString("phoneNumber"));
        guest.setPassport(resultSet.getString("passport"));
        guest.setPassword(resultSet.getString("password"));
        return guest;
    }
}
