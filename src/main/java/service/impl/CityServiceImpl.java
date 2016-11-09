package service.impl;

import entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CityRepository;
import service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    CityRepository cityRepository;

    @Override
    public City findCityById(Integer id) {
        City city = cityRepository.findCityById(id);
        return city;
    }

    @Override
    public City findCityByName(String name) {
        City city = cityRepository.findCityByName(name);
        return city;
    }

    @Override
    public List<City> findAllCities() {
        List<City> cities = cityRepository.findAllCities();
        return cities;
    }

    @Override
    public void save(City city) {
        if(city.getId() == null){
            cityRepository.create(city.getName());
        }
        else {
            cityRepository.update(city.getId(), city.getName());
        }
    }

    @Override
    public void delete(City city) {
        cityRepository.delete(city.getId());
    }
}
