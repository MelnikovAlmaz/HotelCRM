package service.impl;

import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;
import service.EmployeeService;

import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findEmployeeById(Integer id) {
        Employee employee = employeeRepository.findEmployeeById(id);
        return employee;
    }

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAllEmployees();
        return employees;
    }

    @Override
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employeeRepository.create(
                    employee.getName(),
                    employee.getPhoneNumber(),
                    employee.getPassword(),
                    employee.getSalary(),
                    employee.getRole(),
                    employee.getSalaryType(),
                    employee.getDepartment());
        }
        else {
            employeeRepository.update(
                    employee.getId(),
                    employee.getName(),
                    employee.getPhoneNumber(),
                    employee.getPassword(),
                    employee.getSalary(),
                    employee.getFired(),
                    employee.getRole(),
                    employee.getSalaryType(),
                    employee.getDepartment());
        }
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee.getId());
    }

    @Override
    public List<Employee> findAllEmployeesByHotelId(Integer hotelId) {
        List<Employee> employees = employeeRepository.findAllEmployees();
        List<Employee> employeesByHotelId = new LinkedList<>();

        for (Employee employee : employees){
            if(employee.getDepartment() != null) {
                if (employee.getDepartment().getHotel().getId() == hotelId) {
                    employeesByHotelId.add(employee);
                }
            }
        }
        return employeesByHotelId;
    }
}
