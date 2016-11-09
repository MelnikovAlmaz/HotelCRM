package service;

import entity.Guest;

import java.util.List;

public interface GuestService {
    Guest findGuestById(Integer id);
    List<Guest> findAllGuests();
    void save(Guest guest);
    void delete(Guest guest);
}
