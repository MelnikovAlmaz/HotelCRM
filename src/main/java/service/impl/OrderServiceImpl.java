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
        if(order.getId() == null){
            orderRepository.create(order.getBeginDate(), order.getEndDate(), order.getPrice(), order.getGuest(), order.getRoom());
        }
        else {
            orderRepository.update(order.getId(), order.getBeginDate(), order.getEndDate(), order.getPrice(), order.getGuest(), order.getRoom());
        }
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order.getId());
    }

    @Override
    public List<Order> findOrdersOfUser(Guest guest)
    {
        List<Order> orders = findAllOrders();

        List<Order> usersOrders = new ArrayList<>();

        for(Order o: orders)
        {
            if(o.getGuest().getId().compareTo(guest.getId())==0)
            {
                usersOrders.add(o);
            }
        }

        return usersOrders;
    }
}
