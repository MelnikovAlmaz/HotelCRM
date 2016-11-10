package repository;

import entity.City;
import entity.Employee;
import entity.Hotel;
import org.springframework.stereotype.Repository;
import repository.model.HotelInfo;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository {
    Hotel findHotelById(Integer id);
    List<Hotel> findAllHotels();
    void create(String name, String phoneNumber, String address, String description, Employee manager, City city);
    void update(Integer id, String name, String phoneNumber, String address, String description, Employee manager, City city);
    void delete(Integer id);
    List<Hotel> findHotelsByName(String name);
    List<HotelInfo> findHotelInfo(String name, LocalDate beginDate, LocalDate endDate, Integer guestNumber);
    List<Hotel> findHotelsByManagerId(Integer managerId);
}
