package repository;

import entity.Department;
import entity.Employee;
import entity.Role;

import java.util.List;

public interface EmployeeRepository {
    Employee findEmployeeById(Integer id);

    void create(String name, String phoneNumber, String password, Double salary, Role role, String salaryType, Department department);

    void update(Integer id, String name, String phoneNumber, String password, Double salary, Boolean isFired, Role role, String salaryType, Department department);

    void delete(Integer id);

    List<Employee> findAllEmployees();

    Employee findEmployeeByPhoneNumber(String phoneNumber);
}
