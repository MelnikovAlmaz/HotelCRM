package service;

import entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    Hotel findHotelById(Integer id);
    List<Hotel> findAllHotels();
    void save(Hotel hotel);
}
