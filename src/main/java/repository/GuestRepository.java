package repository;

import entity.Guest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository {
    Guest findGuestById(Integer id);
    List<Guest> findAllGuests();

    void create(String firstName, String lastName, String phoneNumber, String password);

    void update(Integer id, String firstName, String lastName, String phoneNumber, String password);

    void delete(Integer id);
}
