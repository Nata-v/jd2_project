package by.nata.web.controllers;

import by.nata.service.AccountService;
import by.nata.service.ClientAddressService;
import by.nata.service.ClientDetailsService;
import by.nata.service.ClientService;
import by.nata.service.model.Client;
import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@Secured("ADMIN")
public class AdminPageController {
    private final ClientService clientService;
    private final ClientDetailsService clientDetailsService;
    private final ClientAddressService clientAddressService;
    private final AccountService accountService;
@Autowired
    public AdminPageController(ClientService clientService, ClientDetailsService clientDetailsService, ClientAddressService clientAddressService, AccountService accountService) {
        this.clientService = clientService;
    this.clientDetailsService = clientDetailsService;
    this.clientAddressService = clientAddressService;
    this.accountService = accountService;
}

    @GetMapping("/admin")
    public  String findClientById(){

        return "/admin";
    }
    @PostMapping("/admin")
    public  String findClientById(@RequestParam("id") String id){

        clientService.findClientById(id);
        return "/admin";
    }


    @PostMapping("/delete")
    public ResponseEntity<String> deleteClientById(@RequestParam(name = "id") String id){
        try {
            clientService.delete(id);
            return ResponseEntity.ok("Client delete successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/deleteAccount")
    public ResponseEntity<String> deleteAccount(@RequestParam(name = "accountId") String accountId){
        try {
            accountService.deleteAccount(accountId);
            return ResponseEntity.ok("Account delete successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
//    @DeleteMapping("/deleteAccount/{accountId}")
//    public ResponseEntity<String> deleteAccount(@PathVariable String accountId) {
//        try {
//            accountService.deleteAccount(accountId);
//            return ResponseEntity.ok("Account delete successful");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }



//    @DeleteMapping("/{id}/delete")
//    //@PostMapping("/{id}/update")
//    public String delete(@PathVariable("id") String id){
//        if( !clientService.delete(id)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        return  "redirect:/login";
//    }




//    @PutMapping("/{id}")
//    //@PostMapping("/{id}/update")
//    public String update(@PathVariable("id") String id,
//                         @ModelAttribute Client client, ClientDetails clientDetails, ClientAddress clientAddress){
//        clientService.updateClient(client, clientDetails, clientAddress);
//        return  "redirect:/profile/{id}";
//    }




}
