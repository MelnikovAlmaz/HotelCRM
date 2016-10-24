package controllers;

import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ClientService;

@Controller
public class MainPageController {
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        Client client = clientService.findClientById(1);
        model.addAttribute("client", client);
        return "main";
    }
}
