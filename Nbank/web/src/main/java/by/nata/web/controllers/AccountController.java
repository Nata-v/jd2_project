package by.nata.web.controllers;

import by.nata.data.model.AccountDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.service.AccountService;
import by.nata.service.model.Account;
import by.nata.service.model.Client;
import by.nata.service.model.ClientDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
@Controller
//@RestController
//@RequestMapping("/accounts")
@Slf4j
@SuppressWarnings({"unused"})
public class AccountController {

    private final AccountService accountService;
@Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account")
   // @Secured("ADMIN")
    public ModelAndView createNewAccount(){
        return new ModelAndView("account");
    }

    @PostMapping("/account")
    //@Secured("ADMIN")
    public ModelAndView registrationClient(Account account, ClientDetails clientDetails) throws IOException {
        System.out.println("Add account: " + account);
       //accountService.createAccount(account.getClientDetails());
       accountService.createAccount(account, clientDetails.getId());

        return new ModelAndView("menubank");
    }

//    @PostMapping("/create")
//    public ResponseEntity<Account> createAccount(Account account, @RequestBody ClientDetails clientDetails) {
//        account = accountService.createAccount(account, clientDetails.getId());
//
//        return new ResponseEntity<>(account, HttpStatus.CREATED);
//    }
}
