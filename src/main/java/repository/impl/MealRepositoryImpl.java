package repository.impl;

import entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.MealRepository;
import repository.mapper.MealMapper;

import java.util.List;

@Repository
public class MealRepositoryImpl implements MealRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MealMapper mealMapper;

    @Override
    public Meal findMealById(Integer id) {
        String SQL = "SELECT * FROM Meal WHERE id = ?";
        Meal meal = jdbcTemplate.queryForObject(SQL, new Object[]{id}, mealMapper);
        return meal;
    }

    @Override
    public void create(String name, Double price, Integer menuId) {
        String SQL = "INSERT INTO Meal (name, price, menuId) VALUES (?, ?, ?)";
        jdbcTemplate.update( SQL, name, price, menuId);
    }

    @Override
    public void update(Integer id, String name, Double price, Integer menuId) {
        String SQL = "UPDATE Meal SET name = ?, price = ?, menuId = ? WHERE id = ?";
        jdbcTemplate.update( SQL, name, price, menuId, id);
    }

    @Override
    public List<Meal> findAllMeals() {
        String SQL = "SELECT * FROM Meal ORDER BY id ASC";
        List<Meal> meals = jdbcTemplate.query(SQL, mealMapper);
        return meals;
    }

    @Override
    public List<Meal> findAllMealsByMenuId(Integer menuId) {
        String SQL = "SELECT * FROM Meal WHERE menuId = ? ORDER BY id ASC";
        List<Meal> meals = jdbcTemplate.query(SQL, new Object[]{menuId}, mealMapper);
        return meals;
    }
}
