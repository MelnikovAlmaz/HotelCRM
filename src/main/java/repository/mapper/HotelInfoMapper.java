package repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import repository.model.HotelInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelInfoMapper implements RowMapper<HotelInfo> {

    @Override
    public HotelInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        HotelInfo hotel = new HotelInfo();
        hotel.setId(resultSet.getInt("id"));
        hotel.setName(resultSet.getString("name"));
        hotel.setAddress(resultSet.getString("address"));
        hotel.setPhoneNumber(resultSet.getString("phoneNumber"));
        hotel.setDescription(resultSet.getString("description"));
        hotel.setPrice((int) resultSet.getDouble("price"));
        hotel.setImageURL(resultSet.getString("imageurl"));
        return hotel;
    }
}
