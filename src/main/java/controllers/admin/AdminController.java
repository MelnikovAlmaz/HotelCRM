package controllers.admin;

import entity.Employee;
import entity.Hotel;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.EmployeeService;
import service.HotelService;
import service.RoleService;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String main(ModelMap model) {
        return "redirect:/admin/dashboard";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(ModelMap model) {
        List<Hotel> hotels = hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "admin/administrator/admin_main";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp() {
        return "admin/auth/signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUpPost(ModelMap model,
                             @RequestParam String name,
                             @RequestParam String phoneNumber,
                             @RequestParam String password,
                             @RequestParam String confirm_password) {
        if(phoneNumber.length() == 11 && password.equals(confirm_password)){
            Employee employee = new Employee();
            employee.setName(name);
            employee.setPhoneNumber(phoneNumber);
            employee.setPassword(password);
            employee.setSalary(0.0);
            employee.setSalaryType("Month");
            Role role =  roleService.findRoleByName("Administrator");
            employee.setRole(role);
            employeeService.save(employee);
        }
        return "redirect:admin/dashboard";
    }

    @RequestMapping(value = "/entity", method = RequestMethod.GET)
    public String entityPage(ModelMap model) {
        return "redirect:/admin/entity/hotels";
    }
}
