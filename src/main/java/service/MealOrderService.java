package service;

import entity.MealOrder;

import java.util.List;

public interface MealOrderService {
    MealOrder findMealOrderById(Integer id);
    void save(MealOrder mealOrder);
    List<MealOrder> findAllMealOrders();
    List<MealOrder> findAllMealOrdersByMenuId(Integer menuId);
}
