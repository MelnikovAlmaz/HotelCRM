package service.impl;

import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
import service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findClientById(Integer id) {
        Client client = clientRepository.findClientById(id);
        return client;
    }

    @Override
    public List<Client> findAllClients() {
        List<Client> clients = clientRepository.findAllClients();
        return clients;
    }

    @Override
    public void save(Client client) {
        if(client.getId() != null) {
            clientRepository.update(client.getId(), client.getFirstName(), client.getLastName(), client.getPhoneNumber());
        }
        else {
            clientRepository.create(client.getFirstName(), client.getLastName(), client.getPhoneNumber());
        }
    }
}
