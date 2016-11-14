package controllers;

import entity.Guest;
import entity.Order;
import entity.Room;
import entity.RoomCategory;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import repository.model.HotelInfo;
import service.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class MainController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private GuestService guestService;
    @Autowired
    private RoomCategoryService roomCategoryService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private OrderService orderService;

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

        model.addAttribute("name", name);
        model.addAttribute("beginDate", beginDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("guestNumber", guestNumber);
        model.addAttribute("hotels", hotels);
        return "search-hotels";
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public String orderGET(ModelMap model,
                           @PathVariable(value = "id") Integer hotelId,
                           @RequestParam(value = "beginDate") String beginDate,
                           @RequestParam(value = "endDate") String endDate,
                           @RequestParam(value = "guestNumber") Integer guestNumber) {
        //TODO free roomCategories by guestNumber
        List<RoomCategory> roomCategories = roomCategoryService.findAllRoomCategoriesByHotelId(hotelId);

        model.addAttribute("roomCategories", roomCategories);
        model.addAttribute("beginDate", beginDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("guestNumber", guestNumber);
        return "hotel_order";
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    Boolean orderPost(@RequestParam(value = "roomCategory") Integer roomCategoryId,
                      @RequestParam(value = "beginDate") String beginDate,
                      @RequestParam(value = "endDate") String endDate,
                      @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                      @RequestParam(value = "name", required = false) String name,
                      @RequestParam(value = "password", required = false) String password) {
        //TODO Check authorization of guest
        Guest guest;
        try {
            guest = guestService.findGuestByPhoneNumber(phoneNumber);
        } catch (Exception e) {
            //TODO delete prints
            e.printStackTrace();
            guest = new Guest();
            guest.setName(name);
            guest.setPhoneNumber(phoneNumber);
            guest.setPassword(password);
            guestService.save(guest);
        }
        RoomCategory roomCategory = roomCategoryService.findRoomCategoryById(roomCategoryId);
        Room room = roomService.findFreeRoomForRoomCategory(roomCategoryId);

        long daysBetween = DAYS.between(LocalDate.parse(beginDate), LocalDate.parse(endDate));
        Double orderPrice = daysBetween * roomCategory.getPrice();

        DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-mm-dd");
        Date begin = new Date(df.parseMillis(beginDate));
        Date end = new Date(df.parseMillis(endDate));

        Order order = new Order();
        order.setPrice(orderPrice);
        order.setBeginDate(begin);
        order.setEndDate(end);
        order.setRoom(room);
        order.setGuest(guest);

        try {
            orderService.save(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/search/hotel", method = RequestMethod.POST)
    public
    @ResponseBody
    List<String> countInMonth(@RequestParam(value = "name") String name) {
        List<String> hotelNames = hotelService.findHotelsByName(name);
        return hotelNames;
    }
}
