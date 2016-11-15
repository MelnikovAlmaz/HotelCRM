package service.impl;

import entity.Guest;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;
import service.OrderService;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order findOrderById(Integer id) {
        Order order = orderRepository.findOrderById(id);
        return order;
    }

    @Override
    public List<Order> findAllOrders() {
        List<Order> orders = orderRepository.findAllOrders();
        return orders;
    }

    @Override
    public void save(Order order) {
        if (order.getId() == null) {
            orderRepository.create(order.getBeginDate(), order.getEndDate(), order.getPrice(), order.getGuest(), order.getRoom());
        } else {
            orderRepository.update(order.getId(), order.getBeginDate(), order.getEndDate(), order.getPrice(), order.getGuest(), order.getRoom(), order.getArived());
        }
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order.getId());
    }

    @Override
    public List<Order> findOrdersByGuest(Guest guest) {
        try {
            List<Order> orders = orderRepository.findOrdersByGuestId(guest.getId());
            return orders;
        }
        catch (NullPointerException e){
            return null;
        }

    }
}