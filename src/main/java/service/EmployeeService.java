package service;

import entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findEmployeeById(Integer id);
    List<Employee> findAllEmployees();
    void save(Employee employee);
    void delete(Employee employee);

    List<Employee> findAllEmployeesByHotelId(Integer hotelId);
}
