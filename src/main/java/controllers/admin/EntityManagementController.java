package controllers.admin;

import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ClientService;
import service.HotelService;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/entity/")
public class EntityManagementController {
    @Autowired
    ClientService clientService;
    @Autowired
    HotelService hotelService;

    @RequestMapping(value = "client", method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        List<Client> clients = clientService.findAllClients();
        model.addAttribute("clients", clients);
        return "admin/entity/client/clients";
    }
}
