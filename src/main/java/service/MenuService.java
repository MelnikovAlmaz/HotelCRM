package service;

import entity.Menu;

import java.util.List;

public interface MenuService {
    Menu findMenuById(Integer id);
    void save(Menu menu);
    List<Menu> findAllMenus();
    List<Menu> findAllMenusByHotelId(Integer hotelId);
}
