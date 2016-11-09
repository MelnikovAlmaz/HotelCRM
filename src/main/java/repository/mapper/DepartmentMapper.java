package repository.mapper;

import entity.Department;
import entity.Employee;
import entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import repository.EmployeeRepository;
import repository.HotelRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DepartmentMapper implements RowMapper<Department> {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Department mapRow(ResultSet resultSet, int i) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getInt("id"));
        department.setName(resultSet.getString("name"));
        Hotel hotel = hotelRepository.findHotelById(resultSet.getInt("hotelId"));
        department.setHotel(hotel);
        Employee manager = employeeRepository.findEmployeeById(resultSet.getInt("managerId"));
        department.setManager(manager);
        return department;
    }
}
