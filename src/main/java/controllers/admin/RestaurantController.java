package controllers.admin;

import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.DepartmentService;
import service.HotelService;
import service.MealService;
import service.MenuService;

import java.util.List;

import static controllers.admin.AdminController.getPrincipal;

@Controller
@RequestMapping("/admin/restaurant")
public class RestaurantController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private MealService mealService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String dashboard(ModelMap model) {
        Employee employee = getPrincipal();
        Department department = departmentService.findDepartmentById(employee.getDepartmentId());
        List<Menu> menus = menuService.findAllMenusByHotelId(department.getHotel().getId());

        model.addAttribute("user", employee);
        model.addAttribute("menus", menus);
        return "admin/restaurant/menus";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newMenu(Model model) {
        Employee employee = getPrincipal();

        model.addAttribute("user", employee);
        return "admin/restaurant/menuAdd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newMenuPost(@RequestParam String name) {
        Employee employee = getPrincipal();
        Department department = departmentService.findDepartmentById(employee.getDepartmentId());
        Menu menu = new Menu();
        menu.setName(name);
        menu.setHotel(department.getHotel());
        menuService.save(menu);
        return "redirect:/admin/restaurant";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String menu(Model model, @PathVariable(value = "id") Integer menuId) {
        Employee employee = getPrincipal();
        List<Meal> meals = mealService.findAllMealsByMenuId(menuId);
        Menu menu = menuService.findMenuById(menuId);

        model.addAttribute("menu", menu);
        model.addAttribute("user", employee);
        model.addAttribute("meals", meals);
        return "admin/restaurant/meals";
    }

    @RequestMapping(value = "/{id}/new", method = RequestMethod.GET)
    public String newmeal(Model model, @PathVariable(value = "id") Integer menuId) {
        Employee employee = getPrincipal();
        Menu menu = menuService.findMenuById(menuId);

        model.addAttribute("menu", menu);
        model.addAttribute("user", employee);
        return "admin/restaurant/mealAdd";
    }

    @RequestMapping(value = "/{id}/new", method = RequestMethod.POST)
    public String newMealPost(@PathVariable(value = "id") Integer menuId,
                              @RequestParam String name,
                              @RequestParam Double price) {
        Meal meal = new Meal();
        meal.setPrice(price);
        meal.setName(name);
        Menu menu = menuService.findMenuById(menuId);
        meal.setMenu(menu);
        mealService.save(meal);
        return "redirect:/admin/restaurant/" + menuId;
    }

    @RequestMapping(value = "/{id}/meal/{mealId}", method = RequestMethod.GET)
    public String meal(Model model,
                       @PathVariable(value = "id") Integer menuId,
                       @PathVariable() Integer mealId) {
        Employee employee = getPrincipal();
        Meal meal = mealService.findMealById(mealId);
        Menu menu = menuService.findMenuById(menuId);

        model.addAttribute("menu", menu);
        model.addAttribute("user", employee);
        model.addAttribute("meal", meal);
        return "admin/restaurant/meal";
    }

    @RequestMapping(value = "/{id}/meal/{mealId}", method = RequestMethod.POST)
    public String mealPost(@PathVariable(value = "id") Integer menuId,
                           @PathVariable() Integer mealId,
                           @RequestParam String name,
                           @RequestParam Double price) {
        Meal meal = mealService.findMealById(mealId);
        meal.setId(mealId);
        meal.setPrice(price);
        meal.setName(name);
        mealService.save(meal);
        return "redirect:/admin/restaurant/" + menuId;
    }
}
