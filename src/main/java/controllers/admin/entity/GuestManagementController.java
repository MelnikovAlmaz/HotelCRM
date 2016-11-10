package controllers.admin.entity;

import entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.GuestService;
import service.HotelService;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/entity/guest")
public class GuestManagementController {
    @Autowired
    GuestService guestService;
    @Autowired
    HotelService hotelService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        List<Guest> guests = guestService.findAllGuests();
        model.addAttribute("guests", guests);
        return "admin/entity/guest/guests";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editPage(ModelMap model, @PathVariable Integer id) {
        Guest guest = guestService.findGuestById(id);
        model.addAttribute("guest", guest);
        return "admin/entity/guest/guest";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String editPage(ModelMap model, @PathVariable Integer id,
                           @RequestParam String name,
                           @RequestParam String phoneNumber,
                           @RequestParam String passport,
                           @RequestParam String password) {
        try {
            Guest guest = new Guest();
            guest.setId(id);
            guest.setName(name);
            guest.setPhoneNumber(phoneNumber);
            guest.setPassport(passport);
            guest.setPassport(password);
            guestService.save(guest);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            model.addAttribute("isSuccess", false);
        }
        return "redirect:/admin/entity/guest/" + id;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addPage() {
        return "admin/entity/guest/guestAdd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addPage(ModelMap model,
                          @RequestParam String name,
                          @RequestParam String phoneNumber,
                          @RequestParam String passport,
                          @RequestParam String password) {
        try {
            Guest guest = new Guest();
            guest.setName(name);
            guest.setPhoneNumber(phoneNumber);
            guest.setPassport(passport);
            guest.setPassword(password);
            guestService.save(guest);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            model.addAttribute("isSuccess", false);
        }
        return "redirect:/admin/entity/guest/new";
    }
}
