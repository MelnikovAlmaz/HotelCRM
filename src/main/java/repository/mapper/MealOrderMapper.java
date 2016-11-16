package repository.mapper;

import entity.Guest;
import entity.MealOrder;
import entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import repository.GuestRepository;
import repository.MenuRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MealOrderMapper implements RowMapper<MealOrder> {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public MealOrder mapRow(ResultSet resultSet, int i) throws SQLException {
        MealOrder mealOrder = new MealOrder();
        mealOrder.setId(resultSet.getInt("id"));
        mealOrder.setPrice(resultSet.getDouble("price"));
        Guest guest = guestRepository.findGuestById(resultSet.getInt("guestId"));
        mealOrder.setGuest(guest);
        Menu menu = menuRepository.findMenuById(resultSet.getInt("menuId"));
        mealOrder.setMenu(menu);
        return mealOrder;
    }
}
