package service.impl;

import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RoleRepository;
import service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findRoleById(Integer id) {
        Role role = roleRepository.findRoleById(id);
        return role;
    }

    @Override
    public Role findRoleByName(String name) {
        Role role = roleRepository.findRoleByName(name);
        return role;
    }

    @Override
    public List<Role> findAllRoles() {
        List<Role> roles = roleRepository.findAllRoles();
        return roles;
    }

    @Override
    public void save(Role role) {
        if(role.getId() == null){
            roleRepository.create(role.getName());
        }
        else {
            roleRepository.update(role.getId(), role.getName());
        }
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role.getId());
    }
}
