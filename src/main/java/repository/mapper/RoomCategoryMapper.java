package repository.mapper;

import entity.Hotel;
import entity.RoomCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import repository.HotelRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RoomCategoryMapper implements RowMapper<RoomCategory> {
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public RoomCategory mapRow(ResultSet resultSet, int i) throws SQLException {
        RoomCategory roomCategory = new RoomCategory();
        roomCategory.setId(resultSet.getInt("id"));
        roomCategory.setName(resultSet.getString("name"));
        roomCategory.setBeds(resultSet.getInt("beds"));
        roomCategory.setPrice(resultSet.getDouble("price"));
        roomCategory.setDescription(resultSet.getString("description"));
        Hotel hotel = hotelRepository.findHotelById(resultSet.getInt("hotelId"));
        roomCategory.setHotel(hotel);
        return roomCategory;
    }
}
