package service;

import entity.Meal;

import java.util.List;

public interface MealService {
    Meal findMealById(Integer id);
    void save(Meal meal);
    List<Meal> findAllMeals();
    List<Meal> findAllMealsByMenuId(Integer menuId);
}
