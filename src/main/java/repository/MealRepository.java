package repository;

import entity.Meal;

import java.util.List;

public interface MealRepository {
    Meal findMealById(Integer id);
    void create(String name, Double price, Integer menuId);
    void update(Integer id, String name, Double price, Integer menuId);
    List<Meal> findAllMeals();
    List<Meal> findAllMealsByMenuId(Integer menuId);
}
