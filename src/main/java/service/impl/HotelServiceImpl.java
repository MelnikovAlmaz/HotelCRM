package service.impl;

import entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repository.HotelRepository;
import service.HotelService;

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
}
