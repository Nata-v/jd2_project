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
import java.time.LocalDate;

@Controller

public class ClientController {

private final ClientService clientService;
private final ClientDetailsService clientDetailsService;
@Autowired
    public ClientController(ClientService clientService, ClientDetailsService clientDetailsService) {
        this.clientService = clientService;
        this.clientDetailsService = clientDetailsService;
    }

@GetMapping("/profile")
public String addClient(){
    return "profile";
}


    @GetMapping("/registration")
    public ModelAndView addClientRegistration(){
        return new ModelAndView("registration");
    }
//@GetMapping("/registration")
//public String addClient(){
//    return "reg";
//}
    @PostMapping("/registration")
    public ModelAndView registrationClient(  Client client, ClientDetails clientDetails) throws IOException {


        System.out.println("Add client: " + client);
        System.out.println("Add clientDetails: " + clientDetails);
        clientDetailsService.saveNewClientDetails(clientDetails);

        clientService.saveNewClient(client);


        return new ModelAndView("bank");
    }




    @GetMapping("/bank")
    public String goFirstPage(){
        return "bank";
    }

    @GetMapping("/info")
    public String goToInfo(){
        return "info";
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
