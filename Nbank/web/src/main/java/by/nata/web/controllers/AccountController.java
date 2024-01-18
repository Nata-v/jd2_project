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


    @GetMapping("/addMoney")
    public String addMoney() {
        return "/addMoney";
    }

    @PostMapping("/addMoney")
    public ResponseEntity<String> depositToAccount(@RequestParam(name = "account_number") String accountNumber,
                                                   @RequestParam(name = "pin") String pin,
                                                   @RequestParam(name = "balance") BigDecimal balance) {
        try {
            accountService.cashDeposit(accountNumber, pin, balance);
            return ResponseEntity.ok("Deposit successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }






}
