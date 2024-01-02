package by.nata.web.controllers;

import by.nata.data.dao.ClientDaoImpl;
import by.nata.service.*;
import by.nata.service.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Locale;

@Controller
//@SessionAttributes({"client"})
public class ClientController {
    private static final Logger log = LoggerFactory.getLogger(ClientController.class);
    @Autowired
    private MessageSource messageSource;

private final ClientService clientService;
private final ClientDetailsService clientDetailsService;
private final ClientAddressService clientAddressService;
@Autowired
    public ClientController(MessageSource messageSource, ClientService clientService, ClientDetailsService clientDetailsService, ClientAddressService clientAddressService) {
    this.messageSource = messageSource;
    this.clientService = clientService;
        this.clientDetailsService = clientDetailsService;
    this.clientAddressService = clientAddressService;
}

@GetMapping("/profile")
public String addClient(){
    return "profile";
}
    @GetMapping("/menubank")
    public String goToMainPage(){
        return "menubank";
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
       // clientDetailsService.saveNewClientDetails(clientDetails);

        clientService.saveNewClient(client, clientDetails, clientAddress);


        return new ModelAndView("login");
    }




    @GetMapping("/login")
    public String goFirstPage(){
        return "login";
    }

    @GetMapping("/info")
    public String goToInfo(){
        return "info";
    }



    @PostMapping("/login")
    public String home(@RequestParam(name = "lang", required = false) String lang, Model model, Locale locale) {
        if (lang != null) {
            locale = new Locale(lang);
        }

        String greetingMessage = messageSource.getMessage("greeting.message", null, locale);
        model.addAttribute("greetingMessage", greetingMessage);

        return "login";
    }



//    @GetMapping
//    public String findAll(Model model){
//        //    model.addAttribute("clients", clientService.findAll());
//         //   model.addAttribute("clients", clientService.findAll(filter));
//            return "client/clients";
//    }
//    @GetMapping("/{id}")
//    public  String findById(@PathVariable("id") String id, Model model){
//        //   model.addAttribute("client", clientService.findById(id));
//            return "client/client";
//    }
//    @PostMapping
//    public String create(@ModelAttribute Client client){
//           clientService.saveNewClient(client);
//            return "redirect:/clients/" + 25;
//    }
    //@PutMapping("/{id}")
    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") String id, @ModelAttribute Client client){
            //clientService.update(id, client);
            return  "redirect:/client/{id}";
    }
//    //@DeleteMapping("/{id}/delete")
//    @PostMapping("/{id}/update")
//    public String delete(@PathVariable("id") String id){
//           clientService.delete(id);
//        return  "redirect:/clients";
//    }
}
