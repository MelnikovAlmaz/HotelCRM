package repository.mapper;

import entity.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet resultSet, int i) throws SQLException {
        Role role = new Role();
        role.setId(resultSet.getInt("id"));
        role.setName(resultSet.getString("name"));
        return role;
    }
}
