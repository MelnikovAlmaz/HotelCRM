package service;

import entity.City;

import java.util.List;

public interface CityService {
    City findCityById(Integer id);
    City findCityByName(String name);
    List<City> findAllCities();
    void save(City city);
    void delete(City city);
}
