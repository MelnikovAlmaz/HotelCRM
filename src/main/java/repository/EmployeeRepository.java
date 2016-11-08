package repository;

import entity.Department;
import entity.Employee;
import entity.Role;

import java.util.List;

public interface EmployeeRepository {
    Employee findEmployeeById(Integer id);
    void create(String name, Double salary, Boolean isFired, Role role, String salaryType, Department department);
    void update(Integer id, String name, Double salary, Boolean isFired, Role role, String salaryType, Department department);
    void delete(Integer id);
    List<Employee> findAllEmployees();
}
