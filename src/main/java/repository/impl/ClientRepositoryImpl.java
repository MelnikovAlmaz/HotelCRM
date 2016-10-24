package repository.impl;

import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.ClientRepository;
import repository.mapper.ClientMapper;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Client findClientById(Integer id) {
        String SQL = "SELECT * FROM Client WHERE id = ?";
        Client student = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new ClientMapper());
        return student;
    }

    @Override
    public List<Client> findAllClients() {
        String SQL = "SELECT * FROM Client ORDER BY id ASC";
        List<Client> clients = jdbcTemplate.query(SQL, new ClientMapper());
        return clients;
    }

    @Override
    public void create(String firstName, String lastName, String phoneNumber) {
        String SQL = "INSERT INTO Client (firstName, lastName, phoneNumber) VALUES (?, ?, ?)";
        jdbcTemplate.update( SQL, firstName, lastName, phoneNumber);
    }

    @Override
    public void update(Integer id, String firstName, String lastName, String phoneNumber) {
        String SQL = "UPDATE Client SET firstName = ?, lastName = ?, phoneNumber = ? WHERE id = ?";
        jdbcTemplate.update( SQL, firstName, lastName, phoneNumber, id);
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM Client WHERE id = ?";
        jdbcTemplate.update( SQL, id);
    }
}
