package service;

import entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    Client findClientById(Integer id);
    List<Client> findAllClients();
    void save(Client client);
}
