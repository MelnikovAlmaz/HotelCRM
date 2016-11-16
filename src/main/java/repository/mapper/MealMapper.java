package repository.mapper;

import entity.Hotel;
import entity.Meal;
import entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import repository.HotelRepository;
import repository.MenuRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MealMapper implements RowMapper<Meal> {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Meal mapRow(ResultSet resultSet, int i) throws SQLException {
        Meal meal = new Meal();
        meal.setId(resultSet.getInt("id"));
        meal.setName(resultSet.getString("name"));
        meal.setPrice(resultSet.getDouble("price"));
        Menu menu = menuRepository.findMenuById(resultSet.getInt("menuId"));
        meal.setMenu(menu);
        return meal;
    }
}
