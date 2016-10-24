package repository;

import entity.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository {
    Client findClientById(Integer id);
    List<Client> findAllClients();
    void create(String firstName, String lastName, String phoneNumber);
    void update(Integer id, String firstName, String lastName, String phoneNumber);
    void delete(Integer id);
}
