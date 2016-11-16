package service.impl;

import entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MealRepository;
import service.MealService;

import java.util.List;

@Service
public class MealServiceImpl implements MealService{
    @Autowired
    private MealRepository mealRepository;

    @Override
    public Meal findMealById(Integer id) {
        return mealRepository.findMealById(id);
    }

    @Override
    public void save(Meal meal) {
        if(meal.getId() == null){
            mealRepository.create(meal.getName(), meal.getPrice(), meal.getMenu().getId());
        }
        else {
            mealRepository.update(meal.getId(), meal.getName(), meal.getPrice(), meal.getMenu().getId());
        }
    }

    @Override
    public List<Meal> findAllMeals() {
        return mealRepository.findAllMeals();
    }

    @Override
    public List<Meal> findAllMealsByMenuId(Integer menuId) {
        return mealRepository.findAllMealsByMenuId(menuId);
    }
}
