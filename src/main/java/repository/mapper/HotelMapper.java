package repository.mapper;

import entity.City;
import entity.Employee;
import entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import repository.CityRepository;
import repository.EmployeeRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class HotelMapper implements RowMapper<Hotel> {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CityRepository cityRepository;

    @Override
    public Hotel mapRow(ResultSet resultSet, int i) throws SQLException {
        Hotel hotel = new Hotel();
        hotel.setId(resultSet.getInt("id"));
        hotel.setName(resultSet.getString("name"));
        hotel.setAddress(resultSet.getString("address"));
        hotel.setPhoneNumber(resultSet.getString("phoneNumber"));
        hotel.setDescription(resultSet.getString("description"));
        Employee manager = employeeRepository.findEmployeeById(resultSet.getInt("managerId"));
        hotel.setManager(manager);
        City city = cityRepository.findCityById(resultSet.getInt("cityId"));
        hotel.setCity(city);
        return hotel;
    }
}
