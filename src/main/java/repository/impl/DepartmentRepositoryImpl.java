package repository.impl;

import entity.Department;
import entity.Employee;
import entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.DepartmentRepository;
import repository.mapper.DepartmentMapper;

import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Department findDepartmentById(Integer id) {
        String SQL = "SELECT * FROM Department WHERE id = ?";
        Department department;
        try {
           department = jdbcTemplate.queryForObject(SQL, new Object[]{id}, departmentMapper);
        }
        catch (EmptyResultDataAccessException e){
            department = null;
        }
        return department;
    }

    @Override
    public void create(String name, Employee manager, Hotel hotel) {
        String SQL = "INSERT INTO Department (name, managerId, hotelId) VALUES (?, ?, ?)";
        jdbcTemplate.update( SQL, name, (manager != null) ? manager.getId() : null, hotel.getId());
    }

    @Override
    public void update(Integer id, String name, Employee manager, Hotel hotel) {
        String SQL = "UPDATE Department SET name = ?, managerId = ?, hotelId = ? WHERE id = ?";
        jdbcTemplate.update( SQL, name, id, (manager != null) ? manager.getId() : null, hotel.getId());
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM Department WHERE id = ?";
        jdbcTemplate.update( SQL, id);
    }

    @Override
    public List<Department> findAllDepartments() {
        String SQL = "SELECT * FROM Department ORDER BY id ASC";
        List<Department> departments = jdbcTemplate.query(SQL, departmentMapper);
        return departments;
    }
}
