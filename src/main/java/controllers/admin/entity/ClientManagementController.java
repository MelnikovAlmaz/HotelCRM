package controllers.admin.entity;

import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ClientService;
import service.HotelService;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/entity/client")
public class ClientManagementController {
    @Autowired
    ClientService clientService;
    @Autowired
    HotelService hotelService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        List<Client> clients = clientService.findAllClients();
        model.addAttribute("clients", clients);
        return "admin/entity/client/clients";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editPage(ModelMap model, @PathVariable Integer id) {
        Client client = clientService.findClientById(id);
        model.addAttribute("client", client);
        return "admin/entity/client/client";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String editPage(ModelMap model, @PathVariable Integer id,
                           @RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String phoneNumber) {
        try {
            Client client = new Client();
            client.setId(id);
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setPhoneNumber(phoneNumber);
            clientService.save(client);

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
                           @RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String phoneNumber) {
        try {
            Client client = new Client();
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setPhoneNumber(phoneNumber);
            clientService.save(client);

            model.addAttribute("isSuccess", true);
        }
        catch (Exception e){
            model.addAttribute("isSuccess", false);
        }
        return "redirect:/admin/entity/client/new";
    }
}
