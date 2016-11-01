package service.impl;

import entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repository.HotelRepository;
import repository.model.HotelInfo;
import service.HotelService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel findHotelById(Integer id) {
        Hotel hotel = hotelRepository.findHotelById(id);
        return hotel;
    }

    @Override
    public List<Hotel> findAllHotels() {
        List<Hotel> hotels = hotelRepository.findAllHotels();
        return hotels;
    }

    @Override
    public void save(Hotel hotel) {
        if(hotel.getId() != null) {
            hotelRepository.update(hotel.getId(), hotel.getName(), hotel.getPhoneNumber(), hotel.getAddress(), hotel.getDescription());
        }
        else {
            hotelRepository.create(hotel.getName(), hotel.getPhoneNumber(), hotel.getAddress(), hotel.getDescription());
        }
    }

    @Override
    public List<String> findHotelsByName(String name) {
        List<Hotel> hotels = hotelRepository.findHotelsByName(name);
        List<String> hotelNames = new LinkedList<>();
        for (Hotel hotel : hotels) {
            hotelNames.add(hotel.getName());
        }
        return hotelNames;
    }

    @Override
    public List<HotelInfo> findHotelInfo(String name, LocalDate beginDate, LocalDate endDate, Integer guestNumber) {
        List<HotelInfo> hotelsInfo = hotelRepository.findHotelInfo(name, beginDate, endDate, guestNumber);
        return hotelsInfo;
    }
}
