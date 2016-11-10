package repository.mapper;

import entity.Department;
import entity.Employee;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import repository.DepartmentRepository;
import repository.RoleRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeMapper implements RowMapper<Employee> {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setPhoneNumber(resultSet.getString("phoneNumber"));
        employee.setFired(resultSet.getBoolean("isFired"));
        employee.setSalary(resultSet.getDouble("salary"));
        employee.setSalaryType(resultSet.getString("salaryType"));
        employee.setPassword(resultSet.getString("password"));
        Role role = roleRepository.findRoleById(resultSet.getInt("roleId"));
        employee.setRole(role);
        Department department = departmentRepository.findDepartmentById(resultSet.getInt("departmentId"));
        employee.setDepartment(department);
        return employee;
    }
}
