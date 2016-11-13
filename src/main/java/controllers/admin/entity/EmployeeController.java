package controllers.admin.entity;

import controllers.admin.AdminController;
import entity.Department;
import entity.Employee;
import entity.Hotel;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.DepartmentService;
import service.EmployeeService;
import service.HotelService;
import service.RoleService;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/entity/{hotelId}/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(ModelMap model, @PathVariable Integer hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        List<Employee> employees = employeeService.findAllEmployeesByHotelId(hotelId);

        Employee employee = AdminController.getPrincipal();
        model.addAttribute("user", employee);
        model.addAttribute("employees", employees);
        model.addAttribute("hotel", hotel);
        return "admin/entity/employee/employees";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editPage(ModelMap model, @PathVariable Integer hotelId, @PathVariable Integer id) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        Employee employee = employeeService.findEmployeeById(id);
        Employee user = AdminController.getPrincipal();
        Department employeeDepartment = departmentService.findDepartmentById(employee.getDepartmentId());
        List<Role> roles = roleService.findAllRoles();
        List<Department> departments = departmentService.findAllDepartmentsByHotelId(hotelId);

        model.addAttribute("employeeDepartment", employeeDepartment);
        model.addAttribute("departments", departments);
        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        model.addAttribute("hotel", hotel);
        model.addAttribute("employee", employee);
        return "admin/entity/employee/employee";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String editPage(ModelMap model, @PathVariable Integer hotelId, @PathVariable Integer id,
                           @RequestParam String name,
                           @RequestParam String phoneNumber,
                           @RequestParam String password,
                           @RequestParam(value = "role") Integer roleId,
                           @RequestParam(value = "departmentId") Integer departmentId,
                           @RequestParam Double salary,
                           @RequestParam String salaryType) {
        try {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setPhoneNumber(phoneNumber);
            employee.setPassword(password);
            employee.setSalary(salary);
            employee.setSalaryType(salaryType);
            Role role = roleService.findRoleById(roleId);
            employee.setRole(role);
            employee.setDepartmentId(departmentId);
            employeeService.save(employee);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("isSuccess", false);
        }
        return "redirect:/admin/entity/" + hotelId +"/employee/" + id;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addPage(ModelMap model, @PathVariable Integer hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        Employee employee = AdminController.getPrincipal();
        List<Role> roles = roleService.findAllRoles();
        List<Department> departments = departmentService.findAllDepartmentsByHotelId(hotelId);

        model.addAttribute("departments", departments);
        model.addAttribute("roles", roles);
        model.addAttribute("user", employee);
        model.addAttribute("hotel", hotel);
        return "admin/entity/employee/employeeAdd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addPagePost(ModelMap model, @PathVariable Integer hotelId,
                              @RequestParam String name,
                              @RequestParam String phoneNumber,
                              @RequestParam String password,
                              @RequestParam(value = "role") Integer roleId,
                              @RequestParam(value = "departmentId") Integer departmentId,
                              @RequestParam Double salary,
                              @RequestParam String salaryType) {
        try {
            Employee employee = new Employee();
            employee.setName(name);
            employee.setPhoneNumber(phoneNumber);
            employee.setPassword(password);
            employee.setSalary(salary);
            employee.setSalaryType(salaryType);
            Role role = roleService.findRoleById(roleId);
            employee.setRole(role);
            employee.setDepartmentId(departmentId);
            employeeService.save(employee);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("isSuccess", false);
            return "redirect:/admin/entity/" + hotelId + "/employee";
        }
        return "redirect:/admin/entity/" + hotelId + "/employee";
    }
}
