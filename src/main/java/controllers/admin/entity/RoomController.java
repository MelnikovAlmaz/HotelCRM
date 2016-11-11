package controllers.admin.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;
import controllers.admin.AdminController;
import entity.Employee;
import entity.Hotel;
import entity.Room;
import entity.RoomCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.HotelService;
import service.RoomCategoryService;
import service.RoomService;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/entity/{hotelId}/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomCategoryService roomCategoryService;
    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(ModelMap model, @PathVariable Integer hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        List<Room> rooms = roomService.findAllRoomsByHotelId(hotelId);

        Employee employee = AdminController.getPrincipal();
        model.addAttribute("user", employee);
        model.addAttribute("rooms", rooms);
        model.addAttribute("hotel", hotel);
        return "admin/entity/room/rooms";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editPage(ModelMap model, @PathVariable Integer hotelId, @PathVariable Integer id) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        Room room = roomService.findRoomById(id);
        Employee employee = AdminController.getPrincipal();
        List<RoomCategory> roomCategories = roomCategoryService.findAllRoomCategoriesByHotelId(hotelId);

        model.addAttribute("categories", roomCategories);
        model.addAttribute("user", employee);
        model.addAttribute("hotel", hotel);
        model.addAttribute("room", room);
        return "admin/entity/room/room";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String editPage(ModelMap model, @PathVariable Integer hotelId, @PathVariable Integer id,
                           @RequestParam Integer number,
                           @RequestParam Boolean isCleaned,
                           @RequestParam Boolean isAvailable,
                           @RequestParam Integer category) {
        try {
            Room room = new Room();
            room.setId(id);
            room.setNumber(number);
            room.setCleaned(isCleaned);
            room.setAvailable(isAvailable);
            RoomCategory roomCategory = roomCategoryService.findRoomCategoryById(category);
            room.setCategory(roomCategory);
            Hotel hotel = hotelService.findHotelById(hotelId);
            room.setHotel(hotel);
            roomService.save(room);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("isSuccess", false);
        }
        return "redirect:/admin/entity/" + hotelId +"/room/" + id;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addPage(ModelMap model, @PathVariable Integer hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        Employee employee = AdminController.getPrincipal();
        List<RoomCategory> roomCategories = roomCategoryService.findAllRoomCategoriesByHotelId(hotelId);

        model.addAttribute("categories", roomCategories);
        model.addAttribute("user", employee);
        model.addAttribute("hotel", hotel);
        return "admin/entity/room/roomAdd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addPagePost(ModelMap model, @PathVariable Integer hotelId,
                              @RequestParam Integer number,
                              @RequestParam Integer category) {
        try {
            Room room = new Room();
            room.setNumber(number);
            RoomCategory roomCategory = roomCategoryService.findRoomCategoryById(category);
            room.setCategory(roomCategory);
            Hotel hotel = hotelService.findHotelById(hotelId);
            room.setHotel(hotel);
            roomService.save(room);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("isSuccess", false);
            return "redirect:/admin/entity/" + hotelId + "/room";
        }
        return "redirect:/admin/entity/" + hotelId + "/room";
    }
}
