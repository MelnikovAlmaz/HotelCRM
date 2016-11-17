package controllers.admin;

import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.*;
import utils.FileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    @Autowired
    private CityService cityService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private FileUpload fileUpload;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String main(ModelMap model) {
        Employee employee = getPrincipal();
        switch (employee.getRole().getName()) {
            case "Accountancy":
                return "redirect:/admin/accountancy";
            case "Chef":
                return "redirect:/admin/restaurant";
            default:
                return "redirect:/admin/dashboard";
        }
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(ModelMap model) {
        Employee employee = getPrincipal();
        List<Hotel> hotels = hotelService.findHotelsByManagerId(employee.getId());

        model.addAttribute("user", employee);
        model.addAttribute("hotels", hotels);
        return "admin/administrator/admin_main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "admin/auth/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/admin/login";
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
        if (phoneNumber.length() == 11 && password.equals(confirm_password)) {
            Employee employee = new Employee();
            employee.setName(name);
            employee.setPhoneNumber(phoneNumber);
            employee.setPassword(password);
            employee.setSalary(1.0);
            employee.setSalaryType("Month");
            Role role = roleService.findRoleByName("Administrator");
            employee.setRole(role);
            employeeService.save(employee);
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/dashboard/hotel/{id}", method = RequestMethod.GET)
    public String hotel(Model model, @PathVariable(value = "id") Integer hotelId) {
        Employee employee = getPrincipal();
        List<City> cities = cityService.findAllCities();
        Hotel hotel = hotelService.findHotelById(hotelId);

        model.addAttribute("hotel", hotel);
        model.addAttribute("user", employee);
        model.addAttribute("cities", cities);
        return "admin/entity/hotel/hotel";
    }

    @RequestMapping(value = "/dashboard/hotel/{id}", method = RequestMethod.POST)
    public String hotelPost(Model model,
                            @PathVariable(value = "id") Integer hotelId,
                            @RequestParam String name,
                            @RequestParam String phoneNumber,
                            @RequestParam String address,
                            @RequestParam(value = "city") Integer cityId,
                            @RequestParam String description,
                            @RequestParam(required = false) MultipartFile image) {
        Employee employee = getPrincipal();
        if (phoneNumber.length() == 11 && name.length() > 0 && cityId != null && cityId > 0) {
            try {
                Hotel hotel = new Hotel();
                hotel.setId(hotelId);
                hotel.setName(name);
                hotel.setPhoneNumber(phoneNumber);
                City city = cityService.findCityById(cityId);
                hotel.setCity(city);
                hotel.setManager(employee);
                hotel.setAddress(address);
                hotel.setDescription(description);

                if(image != null) {
                    String imageURL = fileUpload.IMG_URL + "hotel/" + hotel.getId();
                    fileUpload.validateImage(image);
                    fileUpload.saveImage(imageURL, image);
                    hotel.setImageURL(imageURL);
                }
                hotelService.save(hotel);
                model.addAttribute("isSuccess", true);
                return "redirect:/admin/dashboard";
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("isSuccess", false);
                return "redirect:/admin/dashboard/hotel/" + hotelId;
            }
        } else {
            return "redirect:/admin/dashboard/hotel/" + hotelId;
        }
    }

    @RequestMapping(value = "/dashboard/hotel/new", method = RequestMethod.GET)
    public String newHotel(Model model) {
        Employee employee = getPrincipal();
        List<City> cities = cityService.findAllCities();

        model.addAttribute("user", employee);
        model.addAttribute("cities", cities);
        return "admin/administrator/hotelAdd";
    }

    @RequestMapping(value = "/dashboard/hotel/new", method = RequestMethod.POST)
    public String newHotelPost(Model model,
                               @RequestParam String name,
                               @RequestParam String phoneNumber,
                               @RequestParam String address,
                               @RequestParam(value = "city") Integer cityId,
                               @RequestParam String description,
                               @RequestParam(required = false) MultipartFile image) {
        Employee employee = getPrincipal();
        if (phoneNumber.length() == 11 && name.length() > 0 && cityId != null && cityId > 0) {
            try {
                Hotel hotel = new Hotel();
                hotel.setName(name);
                hotel.setPhoneNumber(phoneNumber);
                City city = cityService.findCityById(cityId);
                hotel.setCity(city);
                hotel.setManager(employee);
                hotel.setAddress(address);
                hotel.setDescription(description);

                if(image != null) {
                    String imageURL = fileUpload.IMG_URL + "hotel/" + hotel.getId();
                    fileUpload.validateImage(image);
                    fileUpload.saveImage(imageURL, image);
                    hotel.setImageURL(imageURL);
                }
                hotelService.save(hotel);
                model.addAttribute("isSuccess", true);
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("isSuccess", false);
            }
            return "redirect:/admin/dashboard";
        } else {
            return "redirect:/admin/dashboard/hotel/new";
        }
    }

    @RequestMapping(value = "/analytic/room/occupancy", method = RequestMethod.GET)
    public
    @ResponseBody
    Double roomOccupancy(ModelMap model,
                    @RequestParam Integer id,
                    @RequestParam String beginDate,
                    @RequestParam String endDate) {
        Room room = roomService.findRoomById(id);
        LocalDate bDate = LocalDate.parse(beginDate);
        Date begin = Date.valueOf(bDate);
        LocalDate eDate = LocalDate.parse(endDate);
        Date end = Date.valueOf(eDate);
        Integer occupancy = roomService.findRoomOrderedDays(room, begin, end);
        long dayCount = bDate.until(eDate, ChronoUnit.DAYS);
        return (double)occupancy * 100 / (double)dayCount;
    }

    public static Employee getPrincipal() {
        Employee employee = (Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return employee;
    }
}
