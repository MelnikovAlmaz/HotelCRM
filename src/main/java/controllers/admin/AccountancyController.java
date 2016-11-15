package controllers.admin;

import entity.Employee;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AccountancyService;
import service.DepartmentService;

import java.util.List;


@Controller
@RequestMapping(value = "/admin/accountancy")
public class AccountancyController {
    @Autowired
    private AccountancyService accountancyService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String dashboard(ModelMap model) {
        Employee employee = AdminController.getPrincipal();


        model.addAttribute("user", employee);
        return "admin/accountancy/accountancy_main";
    }

    @RequestMapping(value = "/search/income_month", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Double> incomeMonth(@RequestParam(value = "date") String date) {
        Employee employee = AdminController.getPrincipal();

        String[] dateInfo = date.split("-");
        Integer year = Integer.valueOf(dateInfo[0]);
        Integer month = Integer.valueOf(dateInfo[1]);

        Integer hotelId = departmentService.findDepartmentById(employee.getDepartmentId()).getHotel().getId();
        List<Double> monthIncome = accountancyService.findMonthIncomeByHotelId(hotelId, year, month);

        return monthIncome;
    }

    @RequestMapping(value = "/search/income_year", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Double> incomeYear(@RequestParam(value = "date") Integer year) {
        Employee employee = AdminController.getPrincipal();

        Integer hotelId = departmentService.findDepartmentById(employee.getDepartmentId()).getHotel().getId();
        List<Double> yearIncome = accountancyService.findYearIncomeByHotelId(hotelId, year);

        return yearIncome;
    }

    @RequestMapping(value = "/search/income_year_month", method = RequestMethod.GET)
    public
    @ResponseBody
    List<List<Double>> incomeYearEachMonth(@RequestParam(value = "date") Integer year) {
        Employee employee = AdminController.getPrincipal();

        Integer hotelId = departmentService.findDepartmentById(employee.getDepartmentId()).getHotel().getId();
        List<List<Double>> yearIncome = accountancyService.findEachMonthYearIncomeByHotelId(hotelId, year);
        return yearIncome;
    }
}
