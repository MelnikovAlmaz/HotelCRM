package repository.impl;

import entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.MenuRepository;
import repository.mapper.MenuMapper;

import java.util.List;

@Repository
public class MenuRepositoryImpl implements MenuRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu findMenuById(Integer id) {
        String SQL = "SELECT * FROM Menu WHERE id = ?";
        Menu menu = jdbcTemplate.queryForObject(SQL, new Object[]{id}, menuMapper);
        return menu;
    }

    @Override
    public void create(String name, Integer hotelId) {
        String SQL = "INSERT INTO Menu (name, hotelId) VALUES (?, ?)";
        jdbcTemplate.update( SQL, name, hotelId);
    }

    @Override
    public void update(Integer id, String name, Integer hotelId) {
        String SQL = "UPDATE Menu SET name = ?, hotelId = ? WHERE id = ?";
        jdbcTemplate.update( SQL, name, hotelId, id);
    }

    @Override
    public void delete(Integer id) {
        String SQL = "DELETE FROM Menu WHERE id = ?";
        jdbcTemplate.update( SQL, id);
    }

    @Override
    public List<Menu> findAllMenus() {
        String SQL = "SELECT * FROM Menu ORDER BY id ASC";
        List<Menu> menus = jdbcTemplate.query(SQL, menuMapper);
        return menus;
    }

    @Override
    public List<Menu> findAllMenusByHotelId(Integer hotelId) {
        String SQL = "SELECT * FROM Menu WHERE hotelId = ?";
        List<Menu> menus = jdbcTemplate.query(SQL, new Object[]{hotelId}, menuMapper);
        return menus;
    }
}
