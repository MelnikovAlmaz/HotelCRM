package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.model.HotelInfo;
import service.HotelService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    HotelService hotelService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage() {
        return "main";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchPageGET() {
        return "redirect:/";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPagePOST(ModelMap model,
                                 @RequestParam(value = "name") String name,
                                 @RequestParam(value = "beginDate") String beginDate,
                                 @RequestParam(value = "endDate") String endDate,
                                 @RequestParam(value = "guestNumber") Integer guestNumber) {
        List<HotelInfo> hotels = hotelService.findHotelInfo(name, LocalDate.parse(beginDate), LocalDate.parse(endDate), guestNumber);
        model.addAttribute("hotels", hotels);
        return "search-hotels";
    }

    @RequestMapping(value = "/search/hotel", method = RequestMethod.POST)
    public @ResponseBody List<String> countInMonth(@RequestParam(value = "name") String name) {
        List<String> hotelNames = hotelService.findHotelsByName(name);
        return hotelNames;
    }
}
