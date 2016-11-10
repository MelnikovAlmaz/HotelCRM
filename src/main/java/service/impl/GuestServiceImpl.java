package service.impl;

import entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GuestRepository;
import service.GuestService;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    GuestRepository guestRepository;

    @Override
    public Guest findGuestById(Integer id) {
        Guest guest = guestRepository.findGuestById(id);
        return guest;
    }

    @Override
    public List<Guest> findAllGuests() {
        List<Guest> guests = guestRepository.findAllGuests();
        return guests;
    }

    @Override
    public void save(Guest guest) {
        if(guest.getId() == null){
            guestRepository.create(guest.getName(), guest.getPhoneNumber(), guest.getPassport());
        }
        else {
            guestRepository.update(guest.getId(), guest.getName(), guest.getPhoneNumber(), guest.getPassport());
        }
    }

    @Override
    public void delete(Guest guest) {
        guestRepository.delete(guest.getId());
    }
}
