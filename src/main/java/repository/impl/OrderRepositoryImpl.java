package repository.impl;

import entity.Guest;
import entity.Order;
import entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.OrderRepository;
import repository.mapper.OrderMapper;

import java.sql.Date;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order findOrderById(Integer id) {
        String SQL = "SELECT * FROM Order WHERE id = ?";
        Order order = jdbcTemplate.queryForObject(SQL, new Object[]{id}, orderMapper);
        return order;
    }

    @Override
    public void create(Date beginDate, Date endDate, Double price, Guest guest, Room room) {
        String SQL = "INSERT INTO \"Order\" (beginDate, endDate, price, guestId, roomId) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, beginDate, endDate, price, guest.getId(), room.getId());
    }

    @Override
    public void update(Integer id, Date beginDate, Date endDate, Double price, Guest guest, Room room) {
        String SQL = "UPDATE Order SET beginDate = ?, endDate = ?, price = ?, guestId = ?, roomId = ? WHERE id = ?";
        jdbcTemplate.update(SQL, beginDate, endDate, price, guest.getId(), room.getId(), id);
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM Order WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public List<Order> findAllOrders() {
        String SQL = "SELECT * FROM Order ORDER BY id ASC";
        List<Order> orders = jdbcTemplate.query(SQL, orderMapper);
        return orders;
    }
}
