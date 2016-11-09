package repository;

import entity.City;

import java.util.List;

public interface CityRepository {
    City findCityById(Integer id);
    void create(String name);
    void update(Integer id, String name);
    void delete(Integer id);
    List<City> findAllCities();

    City findCityByName(String name);
}
