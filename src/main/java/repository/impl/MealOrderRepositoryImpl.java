package repository.impl;

import entity.MealOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.MealOrderRepository;
import repository.mapper.MealOrderMapper;

import java.util.List;

@Repository
public class MealOrderRepositoryImpl implements MealOrderRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MealOrderMapper mealOrderMapper;

    @Override
    public MealOrder findMealOrderById(Integer id) {
        String SQL = "SELECT * FROM MealOrder WHERE id = ?";
        MealOrder mealOrder = jdbcTemplate.queryForObject(SQL, new Object[]{id}, mealOrderMapper);
        return mealOrder;
    }

    @Override
    public void create(Double price, Integer guestId, Integer menuId) {
        String SQL = "INSERT INTO MealOrder (price, guestId, menuId) VALUES (?, ?, ?)";
        jdbcTemplate.update( SQL, price, guestId, menuId);
    }

    @Override
    public void update(Integer id, Double price, Integer guestId, Integer menuId) {
        String SQL = "UPDATE MealOrder SET price = ?, guestId = ?, menuId = ? WHERE id = ?";
        jdbcTemplate.update( SQL, price, guestId, menuId, id);
    }

    @Override
    public List<MealOrder> findAllMealOrders() {
        String SQL = "SELECT * FROM MealOrder ORDER BY orderTime ASC";
        List<MealOrder> mealOrders = jdbcTemplate.query(SQL, mealOrderMapper);
        return mealOrders;
    }

    @Override
    public List<MealOrder> findAllMealOrdersByMenuId(Integer menuId) {
        String SQL = "SELECT * FROM MealOrder WHERE menuId = ? ORDER BY orderTime ASC";
        List<MealOrder> mealOrders = jdbcTemplate.query(SQL, new Object[]{menuId}, mealOrderMapper);
        return mealOrders;
    }
}
