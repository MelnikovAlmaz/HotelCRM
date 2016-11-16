package service.impl;

import entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MenuRepository;
import service.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu findMenuById(Integer id) {
        return menuRepository.findMenuById(id);
    }

    @Override
    public void save(Menu menu) {
        if (menu.getId() == null){
            menuRepository.create(menu.getName(), menu.getHotel().getId());
        }
        else {
            menuRepository.update(menu.getId(), menu.getName(), menu.getHotel().getId());
        }
    }

    @Override
    public List<Menu> findAllMenus() {
        return menuRepository.findAllMenus();
    }

    @Override
    public List<Menu> findAllMenusByHotelId(Integer hotelId) {
        return menuRepository.findAllMenusByHotelId(hotelId);
    }
}
