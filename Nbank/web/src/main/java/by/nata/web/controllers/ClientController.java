package by.nata.web.controllers;

import by.nata.data.model.LoginDto;
import by.nata.service.*;
import by.nata.service.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

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

@GetMapping("/add/profile")
public String addClient() {


    return "add/profile";
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

    public ModelAndView registrationClient( Client client, ClientDetails clientDetails,
                                            ClientAddress clientAddress) throws IOException {

    System.out.println("Add client: " + client);
        System.out.println("Add clientDetails: " + clientDetails);
        System.out.println("Add clientAddress: " + clientAddress);

        clientService.saveNewClient(client, clientDetails, clientAddress);
        return new ModelAndView("login");
    }


    @Secured("ROLE_ADMIN")
    @GetMapping
    public String findAll(Model model, ClientFilter clientFilter){
           // model.addAttribute("client", clientService.findAll());
            model.addAttribute("clientDetails", clientDetailsService.findAllByFilter(clientFilter));
            return "/client/clientFilter";
    }
    @GetMapping("/client/{id}")
    public  String findById(@PathVariable("id") String id, Model model){
          model.addAttribute("client", clientService.findClientById(id));
            return "/client";
    }

//    @GetMapping("/product/{id}")
//    public ModelAndView getProduct(@PathVariable("id") String id) {
//        ProductSpecification product = productService.getProductById(id);
//        ModelAndView modelAndView = new ModelAndView("product-details");
//        modelAndView.addObject("product", product);
//        return modelAndView;
//    }
//    @PostMapping
//    public String create(@ModelAttribute Client client){
//           clientService.saveNewClient(client);
//            return "redirect:/clients/" + 25;
//    }



    @PutMapping("/{id}")
    //@PostMapping("/{id}/update")
    public String update(@PathVariable("id") String id,
                         @ModelAttribute Client client, ClientDetails clientDetails, ClientAddress clientAddress){
            clientService.updateClient(client, clientDetails, clientAddress);
            return  "redirect:/profile/{id}";
    }



    @DeleteMapping("/{id}/delete")
    //@PostMapping("/{id}/update")
    public String delete(@PathVariable("id") String id){
          if( !clientService.delete(id)) {
              throw new ResponseStatusException(HttpStatus.NOT_FOUND);
          }
        return  "redirect:/login";
    }
}
