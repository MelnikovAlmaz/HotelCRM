package controllers.admin;

import entity.Department;
import entity.Employee;
import entity.Hotel;
import entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.DepartmentService;
import service.HotelService;
import service.MenuService;

import java.util.List;

@Controller
@RequestMapping("/admin/restaurant")
public class RestaurantController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String dashboard(ModelMap model) {
        Employee employee = AdminController.getPrincipal();
        Department department = departmentService.findDepartmentById(employee.getDepartmentId());
        List<Menu> menus = menuService.findAllMenusByHotelId(department.getHotel().getId());

        model.addAttribute("user", employee);
        model.addAttribute("menus", menus);
        return "admin/administrator/admin_main";
    }
}
