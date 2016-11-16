package repository;

import entity.MealOrder;

import java.util.List;

public interface MealOrderRepository {
    MealOrder findMealOrderById(Integer id);
    void create(Double price, Integer guestId, Integer menuId);
    void update(Integer id, Double price, Integer guestId, Integer menuId);
    List<MealOrder> findAllMealOrders();
    List<MealOrder> findAllMealOrdersByMenuId(Integer menuId);
}
