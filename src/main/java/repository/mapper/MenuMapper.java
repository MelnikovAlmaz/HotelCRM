package repository.mapper;

import entity.Hotel;
import entity.Menu;
import entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import service.HotelService;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MenuMapper implements RowMapper<Menu> {
    @Autowired
    private HotelService hotelService;

    @Override
    public Menu mapRow(ResultSet resultSet, int i) throws SQLException {
        Menu menu = new Menu();
        menu.setId(resultSet.getInt("id"));
        menu.setName(resultSet.getString("name"));
        Hotel hotel = hotelService.findHotelById(resultSet.getInt("hotelId"));
        menu.setHotel(hotel);
        return menu;
    }
}
