package repository.impl;

import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.RoleRepository;
import repository.mapper.RoleMapper;

import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findRoleById(Integer id) {
        String SQL = "SELECT * FROM Role WHERE id = ?";
        Role role = jdbcTemplate.queryForObject(SQL, new Object[]{id}, roleMapper);
        return role;
    }

    @Override
    public Role findRoleByName(String name) {
        String SQL = "SELECT * FROM Role WHERE name = ?";
        Role role = jdbcTemplate.queryForObject(SQL, new Object[]{name}, roleMapper);
        return role;
    }

    @Override
    public void create(String name) {
        String SQL = "INSERT INTO Role (name) VALUES (?)";
        jdbcTemplate.update( SQL, name);
    }

    @Override
    public void update(Integer id, String name) {
        String SQL = "UPDATE Role SET name = ? WHERE id = ?";
        jdbcTemplate.update( SQL, name, id);
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM Role WHERE id = ?";
        jdbcTemplate.update( SQL, id);
    }

    @Override
    public List<Role> findAllRoles() {
        String SQL = "SELECT * FROM Role ORDER BY name ASC";
        List<Role> roles = jdbcTemplate.query(SQL, roleMapper);
        return roles;
    }
}
