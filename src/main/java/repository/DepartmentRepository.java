package repository;

import entity.Department;
import entity.Employee;
import entity.Hotel;

import java.util.List;

public interface DepartmentRepository {
    Department findDepartmentById(Integer id);
    void create(String name, Employee manager, Hotel hotel);
    void update(Integer id, String name, Employee manager, Hotel hotel);
    void delete(Integer id);
    List<Department> findAllDepartments();
}
