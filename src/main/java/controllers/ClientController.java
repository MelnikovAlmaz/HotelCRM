package controllers;

import entity.Guest;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.OrderRepository;
import service.GuestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/guest")
public class ClientController {
    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUpPost(ModelMap model,
                             @RequestParam String name,
                             @RequestParam String phoneNumber,
                             @RequestParam String password,
                             @RequestParam String confirm_password) {
        if (phoneNumber.length() == 11 && password.equals(confirm_password)) {
            Guest guest = new Guest();
            guest.setName(name);
            guest.setPhoneNumber(phoneNumber);
            guest.setPassword(password);
            guestService.save(guest);
        }
        return "redirect:/";
    }

    public static Guest getPrincipal() {
        Guest guest = null;
        try {
            guest = (Guest) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (NullPointerException | ClassCastException e) {
            e.printStackTrace();
        }
        return guest;
    }

}
