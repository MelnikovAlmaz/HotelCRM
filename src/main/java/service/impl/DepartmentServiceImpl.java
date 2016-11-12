package service.impl;

import entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DepartmentRepository;
import service.DepartmentService;

import java.util.LinkedList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department findDepartmentById(Integer id) {
        Department department = departmentRepository.findDepartmentById(id);
        return department;
    }

    @Override
    public List<Department> findAllDepartments() {
        List<Department> departments = departmentRepository.findAllDepartments();
        return departments;
    }

    @Override
    public void save(Department department) {
        if(department.getId() == null){
            departmentRepository.create(department.getName(), department.getManager(), department.getHotel());
        }
        else {
            departmentRepository.update(department.getId(), department.getName(), department.getManager(), department.getHotel());
        }
    }

    @Override
    public void delete(Department department) {
        departmentRepository.delete(department.getId());
    }

    @Override
    public List<Department> findAllDepartmentsByHotelId(Integer hotelId) {
        List<Department> departments = findAllDepartments();
        List<Department> departmentsByHotelId = new LinkedList<>();
        for(Department department : departments){
            if(department.getHotel().getId() == hotelId){
                departmentsByHotelId.add(department);
            }
        }
        return departmentsByHotelId;
    }
}
