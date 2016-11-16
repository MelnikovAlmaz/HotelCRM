package controllers;

import entity.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import repository.model.HotelInfo;
import service.*;
import utils.ImageUploadException;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        Guest guest = ClientController.getPrincipal();
        List<Order> orders = orderService.findOrdersByGuest(guest);
        model.addAttribute("user", guest);
        model.addAttribute("myOrders", orders);
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
        Guest guest = ClientController.getPrincipal();
        List<Order> orders = orderService.findOrdersByGuest(guest);
        model.addAttribute("myOrders", orders);
        model.addAttribute("user", guest);
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
        Date startDate = Date.valueOf(LocalDate.parse(beginDate));
        Date finishDate = Date.valueOf(LocalDate.parse(endDate));

        List<RoomCategory> roomCategories = roomCategoryService.findAvailableRoomCategoriesByHotelIdInPeriod(hotelId, startDate, finishDate);
        Guest guest = ClientController.getPrincipal();
        Hotel hotel = hotelService.findHotelById(hotelId);
        List<Order> orders = orderService.findOrdersByGuest(guest);
        model.addAttribute("myOrders", orders);
        model.addAttribute("user", guest);
        model.addAttribute("hotel", hotel);
        model.addAttribute("roomCategories", roomCategories);
        model.addAttribute("beginDate", beginDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("guestNumber", guestNumber);
        return "hotel_order";
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.POST)
    public String orderPost(ModelMap model,
                            @PathVariable(value = "id") Integer hotelId,
                            @RequestParam(value = "roomCategory") Integer roomCategoryId,
                            @RequestParam(value = "beginDate") String beginDate,
                            @RequestParam(value = "endDate") String endDate,
                            @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                            @RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "password", required = false) String password) {
        Guest guest = ClientController.getPrincipal();
        if (guest == null) {
            guest = guestService.findGuestByPhoneNumber(phoneNumber);
            if (guest == null) {
                guest = new Guest();
                guest.setName(name);
                guest.setPhoneNumber(phoneNumber);
                guest.setPassword(password);
                guestService.save(guest);
                guest = guestService.findGuestByPhoneNumber(phoneNumber);
            }
        }
        RoomCategory roomCategory = roomCategoryService.findRoomCategoryById(roomCategoryId);
        Room room = roomService.findFreeRoomForRoomCategory(roomCategoryId);

        long daysBetween = DAYS.between(LocalDate.parse(beginDate), LocalDate.parse(endDate));
        Double orderPrice = daysBetween * roomCategory.getPrice();

        LocalDate bDate = LocalDate.parse(beginDate);
        Date begin = Date.valueOf(bDate);
        LocalDate eDate = LocalDate.parse(endDate);
        Date end = Date.valueOf(eDate);

        Order order = new Order();
        order.setPrice(orderPrice);
        order.setBeginDate(begin);
        order.setEndDate(end);
        order.setRoom(room);
        order.setGuest(guest);

        try {
            orderService.save(order);
        } catch (Exception e) {
        } finally {
            Hotel hotel = hotelService.findHotelById(hotelId);
            List<RoomCategory> roomCategories = roomCategoryService.findAllRoomCategoriesByHotelId(hotelId);
            List<Order> orders = orderService.findOrdersByGuest(guest);
            model.addAttribute("myOrders", orders);
            model.addAttribute("roomCategories", roomCategories);
            model.addAttribute("hotel", hotel);
            model.addAttribute("user", guest);
            model.addAttribute("beginDate", beginDate);
            model.addAttribute("endDate", endDate);
            model.addAttribute("guestNumber", roomCategory.getBeds());
            return "hotel_order";
        }
    }

    @RequestMapping(value = "/search/hotel", method = RequestMethod.POST)
    public
    @ResponseBody
    List<String> countInMonth(@RequestParam(value = "name") String name) {
        List<String> hotelNames = hotelService.findHotelsByName(name);
        return hotelNames;
    }


    @RequestMapping(value = "/myorders", method = RequestMethod.GET)
    public String myOrdersPage(ModelMap model) {
        Guest guest = ClientController.getPrincipal();
        List<Order> orders = orderService.findOrdersByGuest(guest);
        model.addAttribute("user", guest);
        model.addAttribute("myOrders", orders);
        return "order-page";
    }

    @RequestMapping(value = "/myorders/{id}/delete", method = RequestMethod.GET)
    public String orderDeletePage(ModelMap model,
                                  @PathVariable Integer id) {
        Guest guest = ClientController.getPrincipal();
        Order order = orderService.findOrderById(id);
        if(order.getGuest().getId() == guest.getId()) {
            orderService.delete(order);
        }
        return "redirect:/myorders";
    }

    @RequestMapping(value = "/myorders/{id}", method = RequestMethod.POST)
    public String orderUpdate(ModelMap model,
                              @PathVariable Integer id,
                              @RequestParam String beginDate,
                              @RequestParam String endDate) {
        Guest guest = ClientController.getPrincipal();
        Order order = orderService.findOrderById(id);
        if(order.getGuest().getId() == guest.getId()) {
            LocalDate bDate = LocalDate.parse(beginDate);
            Date begin = Date.valueOf(bDate);
            LocalDate eDate = LocalDate.parse(endDate);
            Date end = Date.valueOf(eDate);

            order.setBeginDate(begin);
            order.setEndDate(end);
            orderService.save(order);
        }
        return "redirect:/myorders";
    }
}
