package repository.mapper;

import entity.Employee;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import repository.RoleRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeMapper implements RowMapper<Employee> {
    @Autowired
    RoleRepository roleRepository;

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
        employee.setDepartmentId(resultSet.getInt("departmentId"));
        return employee;
    }
}
