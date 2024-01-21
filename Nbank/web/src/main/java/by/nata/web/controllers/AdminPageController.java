package by.nata.web.controllers;

import by.nata.service.*;
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
    private final CardService cardService;
@Autowired
    public AdminPageController(ClientService clientService, ClientDetailsService clientDetailsService, ClientAddressService clientAddressService, AccountService accountService, CardService cardService) {
        this.clientService = clientService;
    this.clientDetailsService = clientDetailsService;
    this.clientAddressService = clientAddressService;
    this.accountService = accountService;
    this.cardService = cardService;
}

    @GetMapping("/admin")
    public  String findClientById(){

        return "/admin";
    }
    @PostMapping("/admin")
    public  ResponseEntity<String> findClientById(@RequestParam(name = "id") String id){
        try {
        clientService.findClientById(id);
            return ResponseEntity.ok("Client found successful" + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
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

    @PostMapping("/findAccount")
    public ResponseEntity<String> findAccountByAccountNumber(@RequestParam(name = "accountNumber") String accountNumber) {
        try {
            accountService.findByAccountNumber(accountNumber);
            return ResponseEntity.ok("Account found successful " + accountNumber);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/deleteAccount")
    public ResponseEntity<String> deleteAccount(@RequestParam(name = "accountNumber") String accountNumber) {
        try {
            accountService.deleteAccountByAccountNumber(accountNumber);
            return ResponseEntity.ok("Account delete successful " + accountNumber);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping("/findCard")
    public ResponseEntity<String> findCardByCardNumber(@RequestParam(name = "cardNumber") String cardNumber) {
        try {
            cardService.findCardByCardNumber(cardNumber);
            return ResponseEntity.ok("Card found successful " + cardNumber);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping("/deleteCard")
    public ResponseEntity<String> deleteCardByCardNumber(@RequestParam(name = "cardNumber") String cardNumber) {
        try {
            cardService.deleteCardByCardNumber(cardNumber);
            return ResponseEntity.ok("Card delete successful " + cardNumber);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



//    @PutMapping("/{id}")
//    //@PostMapping("/{id}/update")
//    public String update(@PathVariable("id") String id,
//                         @ModelAttribute Client client, ClientDetails clientDetails, ClientAddress clientAddress){
//        clientService.updateClient(client, clientDetails, clientAddress);
//        return  "redirect:/profile/{id}";
//    }




}
