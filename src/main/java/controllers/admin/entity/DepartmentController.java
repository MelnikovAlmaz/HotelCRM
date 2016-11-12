package controllers.admin.entity;

import controllers.admin.AdminController;
import entity.Employee;
import entity.Hotel;
import entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.EmployeeService;
import service.HotelService;
import service.DepartmentService;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/entity/{hotelId}/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(ModelMap model, @PathVariable Integer hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        List<Department> departments = departmentService.findAllDepartmentsByHotelId(hotelId);

        Employee employee = AdminController.getPrincipal();
        model.addAttribute("user", employee);
        model.addAttribute("departments", departments);
        model.addAttribute("hotel", hotel);
        return "admin/entity/department/departments";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editPage(ModelMap model, @PathVariable Integer hotelId, @PathVariable Integer id) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        Department department = departmentService.findDepartmentById(id);
        Employee employee = AdminController.getPrincipal();
        List<Employee> employees = employeeService.findAllEmployeesByHotelId(hotelId);

        model.addAttribute("employees", employees);
        model.addAttribute("user", employee);
        model.addAttribute("hotel", hotel);
        model.addAttribute("department", department);
        return "admin/entity/department/department";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String editPage(ModelMap model, @PathVariable Integer hotelId, @PathVariable Integer id,
                           @RequestParam String name,
                           @RequestParam(value = "manager", required = false) Integer managerId) {
        try {
            Department department = new Department();
            department.setId(id);
            department.setName(name);
            Employee manager = null;
            if(managerId != null) {
                manager = employeeService.findEmployeeById(managerId);
            }
            department.setManager(manager);
            Hotel hotel = hotelService.findHotelById(hotelId);
            department.setHotel(hotel);
            departmentService.save(department);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("isSuccess", false);
        }
        return "redirect:/admin/entity/" + hotelId +"/department/" + id;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addPage(ModelMap model, @PathVariable Integer hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        Employee employee = AdminController.getPrincipal();
        List<Employee> employees = employeeService.findAllEmployeesByHotelId(hotelId);

        model.addAttribute("employees", employees);
        model.addAttribute("user", employee);
        model.addAttribute("hotel", hotel);
        return "admin/entity/department/departmentAdd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addPagePost(ModelMap model, @PathVariable Integer hotelId,
                              @RequestParam String name,
                              @RequestParam(value = "manager", required = false) Integer managerId) {
        try {
            Department department = new Department();
            department.setName(name);
            Employee manager = null;
            if(managerId != null) {
                 manager = employeeService.findEmployeeById(managerId);
            }
            department.setManager(manager);
            Hotel hotel = hotelService.findHotelById(hotelId);
            department.setHotel(hotel);
            departmentService.save(department);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("isSuccess", false);
            return "redirect:/admin/entity/" + hotelId + "/department";
        }
        return "redirect:/admin/entity/" + hotelId + "/department";
    }
}
