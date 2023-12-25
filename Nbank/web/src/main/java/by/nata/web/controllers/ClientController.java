package by.nata.web.controllers;

import by.nata.service.*;
import by.nata.service.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

private final ClientService clientService;
private final ClientDetailsService clientDetailsService;
private  final ClientAddressService clientAddressService;
private final CitiesService citiesService;
private final IssuingAuthorityService issuingAuthorityService;
private final ClientDetails clientDetails;
private final ClientAddress clientAddress;

        @GetMapping("/online-registration")
    public ModelAndView getAddClientRegistration(){
        return new ModelAndView("online-registration");
    }

    @PostMapping("/online-registration")
    public ModelAndView registrationNewClient(Model model, @ModelAttribute("client") Client client) {

            model.addAttribute("client", client);
         //   model.addAttribute("client_details", clientDetails);
           // model.addAttribute("client_address", clientAddress);
        //    model.addAttribute("cities", citiesService.findAll());
          //  model.addAttribute("issuing_authority", issuingAuthorityService.findAll());

//        System.out.println("Add username: " + model);
//        System.out.println("Add password: " + model);
//        System.out.println("Add email: " + model);


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
