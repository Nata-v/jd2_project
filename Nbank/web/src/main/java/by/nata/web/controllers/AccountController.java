package by.nata.web.controllers;

import by.nata.data.dao.ClientAddressDao;
import by.nata.data.dao.ClientDao;
import by.nata.data.dao.ClientDetailsDao;
import by.nata.data.model.AccountDto;
import by.nata.data.model.ClientAddressDto;
import by.nata.data.model.ClientDetailsDto;
import by.nata.data.model.ClientDto;
import by.nata.service.AccountService;
import by.nata.service.ClientAddressService;
import by.nata.service.ClientDetailsService;
import by.nata.service.ClientService;
import by.nata.service.model.Account;
import by.nata.service.model.Client;
import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;

@Controller
//@RestController
//@RequestMapping("/accounts")
@Slf4j
@SuppressWarnings({"unused"})
public class AccountController {

    private final AccountService accountService;
    private final ClientService clientService;


    @Autowired
    public AccountController(AccountService accountService, ClientService clientService) {
        this.accountService = accountService;
        this.clientService = clientService;

    }

    @GetMapping("/account")
    public ModelAndView createNewAccount() {
        return new ModelAndView("account");
    }

    @PostMapping("/account")
    public ModelAndView registrationNewAccount(Authentication authentication, @ModelAttribute("account") AccountDto account
    ) throws IOException {

        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            Client client = clientService.findByUsername(username);

            if (client != null ) {
                String clientId = client.getId();
                accountService.createAccount(account, clientId);
            }
        }
        return new ModelAndView("login");
    }

//    @PutMapping("/accountOperations/{accountId}")
//    public ResponseEntity<String> updateAccount(@PathVariable String accountId,
//                                                @RequestParam BigDecimal newBalance,
//                                                @RequestParam String newDate) {
//        try {
//            ZonedDateTime parsedDate = ZonedDateTime.parse(newDate);
//            accountService.updateAccount(accountId, newBalance, parsedDate);
//            return ResponseEntity.ok("Account updated successfully.");
//        } catch (Exception e) {
//
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input.");
//        }
//    }

    @GetMapping("/accountOperation")
    public String showAccountOperation() {
        return "/accountOperation";
    }

    //@PostMapping("/accountOperation/{accountId}")
//    @PostMapping("/accountOperation")
//    public String updateAccount(Authentication authentication, @ModelAttribute("account") Account account) {
//        BigDecimal newBalance = account.getBalance();
//        ZonedDateTime newDate = account.getDateLastVisit();
//        if (authentication != null) {
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            String username = userDetails.getUsername();
//            Client client = clientService.findByUsername(username);
//
//            if (client != null ) {
//                String clientId = client.getId();
//
//                by.nata.data.entity.Account accountNumber = accountService.findByAccountNumber(account.getAccountNumber());
//        accountService.updateAccount(account, clientId);
//
//        return "redirect:/bank";
//    }


//    @PostMapping("/create")
//    public ResponseEntity<Account> createAccount(Account account, @RequestBody ClientDetails clientDetails) {
//        account = accountService.createAccount(account, clientDetails.getId());
//
//        return new ResponseEntity<>(account, HttpStatus.CREATED);
//    }


}
