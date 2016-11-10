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
@RequestMapping(value = "/admin/entity/client")
public class GuestManagementController {
    @Autowired
    GuestService guestService;
    @Autowired
    HotelService hotelService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        List<Guest> guests = guestService.findAllGuests();
        model.addAttribute("clients", guests);
        return "admin/entity/client/clients";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editPage(ModelMap model, @PathVariable Integer id) {
        Guest guest = guestService.findGuestById(id);
        model.addAttribute("client", guest);
        return "admin/entity/client/client";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String editPage(ModelMap model, @PathVariable Integer id,
                           @RequestParam String name,
                           @RequestParam String phoneNumber,
                           @RequestParam String passport) {
        try {
            Guest guest = new Guest();
            guest.setId(id);
            guest.setName(name);
            guest.setPhoneNumber(phoneNumber);
            guest.setPassport(passport);
            guestService.save(guest);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            model.addAttribute("isSuccess", false);
        }
        return "redirect:/admin/entity/client/" + id;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addPage() {
        return "admin/entity/client/clientAdd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addPage(ModelMap model,
                          @RequestParam String name,
                          @RequestParam String phoneNumber,
                          @RequestParam String passport) {
        try {
            Guest guest = new Guest();
            guest.setName(name);
            guest.setPhoneNumber(phoneNumber);
            guest.setPassport(passport);
            guestService.save(guest);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            model.addAttribute("isSuccess", false);
        }
        return "redirect:/admin/entity/client/new";
    }
}
