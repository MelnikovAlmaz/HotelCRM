package service;

import entity.Order;

import java.util.List;

public interface OrderService {
    Order findOrderById(Integer id);
    List<Order> findAllOrders();
    void save(Order order);
    void delete(Order order);
}
