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
//@PostMapping("/registration")
//
//public ModelAndView registrationClient(@ModelAttribute("client") @Valid Client client,
//                                       @Validated ClientDetails clientDetails,
//                                       @Validated  ClientAddress clientAddress,
//                                       BindingResult bindingResult, Model model) throws IOException {
//    if (bindingResult.hasErrors()) {
//        return new ModelAndView("registration");
//    }
//
//        Client existingClient = clientService.findByUsername(client.getUsername());
//        if (existingClient != null) {
//            model.addAttribute("usernameExists", true);
//            return new ModelAndView("registration");
//    }
//
//    clientService.saveNewClient(client, clientDetails, clientAddress);
//    return new ModelAndView("login");
//
//}

}
