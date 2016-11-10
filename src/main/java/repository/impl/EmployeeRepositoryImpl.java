package repository.impl;

import entity.Department;
import entity.Employee;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.EmployeeRepository;
import repository.mapper.EmployeeMapper;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee findEmployeeById(Integer id) {
        String SQL = "SELECT * FROM Employee WHERE id = ?";
        Employee employee = jdbcTemplate.queryForObject(SQL, new Object[]{id}, employeeMapper);
        return employee;
    }

    @Override
    public void create(String name, String phoneNumber, String password, Double salary, Boolean isFired, Role role, String salaryType, Department department) {
        String SQL = "INSERT INTO Employee (name, phoneNumber, password, salary, isFired, roleId, salaryType, departmentId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, name, phoneNumber, password, salary, isFired, role.getId(), salaryType, department.getId());
    }

    @Override
    public void update(Integer id, String name, String phoneNumber, String password, Double salary, Boolean isFired, Role role, String salaryType, Department department) {
        String SQL = "UPDATE Employee SET name = ? phoneNumber = ? password = ? salary = ? isFired = ? roleId = ? salaryType = ? departmentId = ? WHERE id = ?";
        jdbcTemplate.update(SQL, name, phoneNumber, password, salary, isFired, role.getId(), salaryType, department.getId(), id);
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM Employee WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        String SQL = "SELECT * FROM Employee ORDER BY id ASC";
        List<Employee> employees = jdbcTemplate.query(SQL, employeeMapper);
        return employees;
    }
}
