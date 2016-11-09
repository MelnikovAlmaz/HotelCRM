package service;

import entity.Department;

import java.util.List;

public interface DepartmentService {
    Department findDepartmentById(Integer id);
    List<Department> findAllDepartments();
    void save(Department department);
    void delete(Department department);
}
