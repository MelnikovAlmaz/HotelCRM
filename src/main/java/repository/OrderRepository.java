package repository;

import entity.Guest;
import entity.Order;
import entity.Room;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository {
    Order findOrderById(Integer id);
    void create(LocalDate beginDate, LocalDate endDate, Double price, Guest guest, Room room);
    void update(Integer id, LocalDate beginDate, LocalDate endDate, Double price, Guest guest, Room room);
    void delete(Integer id);
    List<Order> findAllOrders();
}
