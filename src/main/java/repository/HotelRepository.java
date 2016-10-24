package repository;

import entity.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository {
    Hotel findHotelById(Integer id);
    List<Hotel> findAllHotels();
    void create(String name, String phoneNumber, String address, String description);
    void update(Integer id, String name, String phoneNumber, String address, String description);
    void delete(Integer id);
}
