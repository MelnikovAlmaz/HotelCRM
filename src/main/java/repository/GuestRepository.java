package repository;

import entity.Guest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository {
    Guest findGuestById(Integer id);
    List<Guest> findAllGuests();

    void create(String name, String phoneNumber, String passport, String password);

    void update(Integer id, String name, String phoneNumber, String passport, String password);

    void delete(Integer id);

    Guest findGuestByPhoneNumber(String phoneNumber);
}
