package service;

import entity.Hotel;
import org.springframework.stereotype.Service;
import repository.model.HotelInfo;

import java.time.LocalDate;
import java.util.List;

@Service
public interface HotelService {
    Hotel findHotelById(Integer id);
    List<Hotel> findAllHotels();
    void save(Hotel hotel);
    List<String> findHotelsByName(String name);
    List<HotelInfo> findHotelInfo(String name, LocalDate beginDate, LocalDate endDate, Integer guestNumber);
}
