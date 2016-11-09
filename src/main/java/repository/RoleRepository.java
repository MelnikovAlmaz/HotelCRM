package repository;

import entity.Role;

import java.util.List;

public interface RoleRepository {
    Role findRoleById(Integer id);
    void create(String name);
    void update(Integer id, String name);
    void delete(Integer id);
    List<Role> findAllRoles();
}
