package controllers.admin.entity;

import entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.HotelService;
import utils.FileUpload;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/entity/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private FileUpload fileUpload;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        List<Hotel> hotels = hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "admin/entity/hotel/hotels";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editPage(ModelMap model, @PathVariable Integer id) {
        Hotel hotel = hotelService.findHotelById(id);
        model.addAttribute("hotel", hotel);
        return "admin/entity/hotel/hotel";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String editPage(ModelMap model, @PathVariable Integer id,
                           @RequestParam String name,
                           @RequestParam String phoneNumber,
                           @RequestParam String address,
                           @RequestParam String description,
                           @RequestParam MultipartFile image) {
        try {
            Hotel hotel = new Hotel();
            hotel.setId(id);
            hotel.setName(name);
            hotel.setPhoneNumber(phoneNumber);
            hotel.setAddress(address);
            hotel.setDescription(description);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            model.addAttribute("isSuccess", false);
        }
        return "redirect:/admin/entity/hotel/" + id;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addPage() {
        return "admin/administrator/hotelAdd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addPage(ModelMap model,
                          @RequestParam String name,
                          @RequestParam String phoneNumber,
                          @RequestParam String address,
                          @RequestParam String description,
                          @RequestParam MultipartFile image) {
        try {
            Hotel hotel = new Hotel();
            hotel.setName(name);
            hotel.setPhoneNumber(phoneNumber);
            hotel.setAddress(address);
            hotel.setDescription(description);

            String imageURL = fileUpload.IMG_URL + "hotel" + hotel.getId();
            fileUpload.validateImage(image);
            fileUpload.saveImage(imageURL, image);
            hotel.setImageURL(imageURL);
            hotelService.save(hotel);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            model.addAttribute("isSuccess", false);
        }
        return "redirect:/admin/entity/hotel/new";
    }
}
