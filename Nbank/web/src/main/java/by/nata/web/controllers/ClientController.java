package by.nata.web.controllers;

import by.nata.service.*;
import by.nata.service.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
//@RequestMapping("/clients")

public class ClientController {
@Autowired
private final ClientService clientService;
private final ClientDetailsService clientDetailsService;
private  final ClientAddressService clientAddressService;
private final CitiesService citiesService;
private final IssuingAuthorityService issuingAuthorityService;
private final ClientDetails clientDetails;
private final ClientAddress clientAddress;

    public ClientController(ClientService clientService, ClientDetailsService clientDetailsService, ClientAddressService clientAddressService, CitiesService citiesService, IssuingAuthorityService issuingAuthorityService, ClientDetails clientDetails, ClientAddress clientAddress) {
        this.clientService = clientService;
        this.clientDetailsService = clientDetailsService;
        this.clientAddressService = clientAddressService;
        this.citiesService = citiesService;
        this.issuingAuthorityService = issuingAuthorityService;
        this.clientDetails = clientDetails;
        this.clientAddress = clientAddress;
    }

    @GetMapping("/online-registration")
    public ModelAndView getAddClientRegistration(){
        return new ModelAndView("online-registration");
    }
//    @GetMapping("/online-registration")
//    public String helloPage(){
//        return "bank/online-registration";
//    }

    @PostMapping("/online-registration")
    public ModelAndView registrationNewClient(  Client client) throws IOException {

           // model.addAttribute("client", client);

         //   model.addAttribute("client_details", clientDetails);
           // model.addAttribute("client_address", clientAddress);
        //    model.addAttribute("cities", citiesService.findAll());
          //  model.addAttribute("issuing_authority", issuingAuthorityService.findAll());

        System.out.println("Add username: " + client);
        System.out.println("Add password: " + client);
        System.out.println("Add email: " + client);
clientService.saveNewClient(client);

        return new ModelAndView("index");
    }
    @GetMapping
    public String findAll(Model model){
        //    model.addAttribute("clients", clientService.findAll());
         //   model.addAttribute("clients", clientService.findAll(filter));
            return "client/clients";
    }
    @GetMapping("/{id}")
    public  String findById(@PathVariable("id") String id, Model model){
        //    model.addAttribute("client", clientService.findById(id));
            return "client/client";
    }
    @PostMapping
    public String create(@ModelAttribute Client client){
           clientService.saveNewClient(client);
            return "redirect:/clients/" + 25;
    }
    //@PutMapping("/{id}")
    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") String id, @ModelAttribute Client client){
         //   clientService.update(id, client);
            return  "redirect:/clients/{id}";
    }
    //@DeleteMapping("/{id}/delete")
    @PostMapping("/{id}/update")
    public String delete(@PathVariable("id") String id){
        //   clientService.delete(id);
        return  "redirect:/clients";
    }
}
