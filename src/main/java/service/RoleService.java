package service;

import entity.Role;

import java.util.List;

public interface RoleService {
    Role findRoleById(Integer id);
    List<Role> findAllRoles();
    void save(Role role);
    void delete(Role role);
}
