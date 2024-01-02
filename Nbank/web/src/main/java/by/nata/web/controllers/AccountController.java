package by.nata.web.controllers;

import by.nata.service.AccountService;
import by.nata.service.model.Client;
import by.nata.service.model.ClientDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
@Controller
@Slf4j
public class AccountController {

    private final AccountService accountService;
@Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account")
    public ModelAndView createNewAccount(){
        return new ModelAndView("account");
    }

//    @PostMapping("/registration")
//    public ModelAndView registrationClient(Client client, ClientDetails clientDetails) throws IOException {
//
//
//        System.out.println("Add client: " + client);
//        System.out.println("Add clientDetails: " + clientDetails);
//        clientDetailsService.saveNewClientDetails(clientDetails);
//
//        clientService.saveNewClient(client);
//
//
//        return new ModelAndView("bank");
//    }
}
