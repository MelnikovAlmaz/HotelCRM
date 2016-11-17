package repository.impl;

import entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.CityRepository;
import repository.mapper.CityMapper;

import java.util.List;

@Repository
public class CityRepositoryImpl implements CityRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CityMapper cityMapper;

    @Override
    public City findCityById(Integer id) {
        String SQL = "SELECT * FROM City WHERE id = ?";
        City city = jdbcTemplate.queryForObject(SQL, new Object[]{id}, cityMapper);
        return city;
    }

    @Override
    public void create(String name) {
        String SQL = "INSERT INTO City (name) VALUES (?)";
        jdbcTemplate.update( SQL, name);
    }

    @Override
    public void update(Integer id, String name) {
        String SQL = "UPDATE City SET name = ? WHERE id = ?";
        jdbcTemplate.update( SQL, name, id);
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM City WHERE id = ?";
        jdbcTemplate.update( SQL, id);
    }

    @Override
    public List<City> findAllCities() {
        String SQL = "SELECT * FROM City ORDER BY name ASC";
        List<City> cities = jdbcTemplate.query(SQL, cityMapper);
        return cities;
    }

    @Override
    public City findCityByName(String name) {
        String SQL = "SELECT * FROM City WHERE name = ? ORDER BY name ASC";
        City city = jdbcTemplate.queryForObject(SQL, new Object[]{name}, cityMapper);
        return city;
    }
}
