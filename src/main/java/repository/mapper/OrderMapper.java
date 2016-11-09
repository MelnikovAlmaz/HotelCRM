package repository.mapper;

import entity.Guest;
import entity.Order;
import entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import repository.GuestRepository;
import repository.RoomRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderMapper implements RowMapper<Order> {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setBeginDate(resultSet.getDate("beginDate"));
        order.setEndDate(resultSet.getDate("endDate"));
        order.setPrice(resultSet.getDouble("price"));
        order.setOrderTime(resultSet.getTimestamp("orderTime"));
        Room room = roomRepository.findRoomById(resultSet.getInt("roomId"));
        order.setRoom(room);
        Guest guest = guestRepository.findGuestById(resultSet.getInt("guestId"));
        order.setGuest(guest);
        return order;
    }
}
