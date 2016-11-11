package controllers.admin.entity;

import controllers.admin.AdminController;
import entity.Employee;
import entity.Hotel;
import entity.RoomCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.RoomCategoryService;
import service.HotelService;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/entity/{hotelId}/roomcategory")
public class RoomCategoryController {
    @Autowired
    RoomCategoryService roomCategoryService;
    @Autowired
    HotelService hotelService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(ModelMap model, @PathVariable Integer hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        List<RoomCategory> roomcategories = roomCategoryService.findAllRoomCategoriesByHotelId(hotelId);

        Employee employee = AdminController.getPrincipal();
        model.addAttribute("user", employee);
        model.addAttribute("roomcategories", roomcategories);
        model.addAttribute("hotel", hotel);
        return "admin/entity/roomcategory/roomcategories";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editPage(ModelMap model, @PathVariable Integer hotelId, @PathVariable Integer id) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        RoomCategory roomcategory = roomCategoryService.findRoomCategoryById(id);
        Employee employee = AdminController.getPrincipal();
        model.addAttribute("user", employee);
        model.addAttribute("hotel", hotel);
        model.addAttribute("roomcategory", roomcategory);
        return "admin/entity/roomcategory/roomcategory";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String editPage(ModelMap model, @PathVariable Integer hotelId, @PathVariable Integer id,
                           @RequestParam String name,
                           @RequestParam Integer beds,
                           @RequestParam Double price,
                           @RequestParam String description) {
        try {
            RoomCategory roomcategory = new RoomCategory();
            roomcategory.setId(id);
            roomcategory.setName(name);
            roomcategory.setBeds(beds);
            roomcategory.setPrice(price);
            roomcategory.setDescription(description);
            Hotel hotel = hotelService.findHotelById(hotelId);
            roomcategory.setHotel(hotel);
            roomCategoryService.save(roomcategory);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("isSuccess", false);
        }
        return "redirect:/admin/entity/" + hotelId +"/roomcategory/" + id;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addPage(ModelMap model, @PathVariable Integer hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        Employee employee = AdminController.getPrincipal();
        model.addAttribute("user", employee);
        model.addAttribute("hotel", hotel);
        return "admin/entity/roomcategory/roomcategoryAdd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addPagePost(ModelMap model, @PathVariable Integer hotelId,
                          @RequestParam String name,
                          @RequestParam Integer beds,
                          @RequestParam Double price,
                          @RequestParam String description) {
        try {
            RoomCategory roomcategory = new RoomCategory();
            roomcategory.setName(name);
            roomcategory.setBeds(beds);
            roomcategory.setPrice(price);
            roomcategory.setDescription(description);
            Hotel hotel = hotelService.findHotelById(hotelId);
            roomcategory.setHotel(hotel);
            roomCategoryService.save(roomcategory);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("isSuccess", false);
            return "redirect:/admin/entity/" + hotelId + "/roomcategory/new";
        }
        return "redirect:/admin/entity/" + hotelId + "/roomcategory";
    }
}
