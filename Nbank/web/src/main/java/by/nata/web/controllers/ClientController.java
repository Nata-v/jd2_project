package by.nata.web.controllers;

import by.nata.service.*;
import by.nata.service.model.*;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
//@SessionAttributes({"client"})
@SuppressWarnings({"unused"})
public class ClientController {
    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

private final ClientService clientService;
private final ClientDetailsService clientDetailsService;
private final ClientAddressService clientAddressService;
@Autowired
    public ClientController(ClientService clientService, ClientDetailsService clientDetailsService, ClientAddressService clientAddressService) {
    this.clientService = clientService;
        this.clientDetailsService = clientDetailsService;
    this.clientAddressService = clientAddressService;
}




    @GetMapping("/bank/{id}")
    public String goMainPage(@CookieValue ("JSESSIONID") String jsessionId,
                             @PathVariable("id") String id,
                             Model model, Client client){
    model.addAttribute("client", client);
    return "/bank";
    }


    @GetMapping("/registration")
    public ModelAndView addClientRegistration(){
        return new ModelAndView("registration");
    }

    @PostMapping("/registration")

    public ModelAndView registrationClient(@Validated Client client, @Validated ClientDetails clientDetails,
                                           @Validated  ClientAddress clientAddress,
                                           BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
if (bindingResult.hasErrors()){
    redirectAttributes.addFlashAttribute("client", client);
    redirectAttributes.addFlashAttribute("clientDetails", clientDetails);
    redirectAttributes.addFlashAttribute("clientAddress", clientAddress);

    redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
    return  new ModelAndView("registration");
}

        clientService.saveNewClient(client, clientDetails, clientAddress);
        return new ModelAndView("login");
    }


}
