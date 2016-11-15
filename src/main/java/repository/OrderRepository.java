package repository;

import entity.Guest;
import entity.Order;
import entity.Room;

import java.sql.Date;
import java.util.List;

public interface OrderRepository {
    Order findOrderById(Integer id);

    void create(Date beginDate, Date endDate, Double price, Guest guest, Room room);

    void update(Integer id, Date beginDate, Date endDate, Double price, Guest guest, Room room);

    void delete(Integer id);

    List<Order> findAllOrders();

    List<Order> findOrdersByGuestId(Integer id);
}
