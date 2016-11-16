package repository;

import entity.Menu;

import java.util.List;

public interface MenuRepository {
    Menu findMenuById(Integer id);
    void create(String name, Integer hotelId);
    void update(Integer id, String name, Integer hotelId);
    void delete(Integer id);
    List<Menu> findAllMenus();
    List<Menu> findAllMenusByHotelId(Integer hotelId);
}
