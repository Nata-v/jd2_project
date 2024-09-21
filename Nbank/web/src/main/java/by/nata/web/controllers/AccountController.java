package by.nata.web.controllers;

import by.nata.data.entity.Currency;
import by.nata.service.AccountService;
import by.nata.service.ClientService;
import by.nata.service.TransactionsService;
import by.nata.service.model.Account;
import by.nata.service.model.Client;
import by.nata.service.model.Transactions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.math.BigDecimal;

@Controller
@Slf4j
@SuppressWarnings({"unused"})
public class AccountController {

    private final AccountService accountService;
    private final ClientService clientService;
    private final TransactionsService transactionsService;


    @Autowired
    public AccountController(AccountService accountService, ClientService clientService, TransactionsService transactionsService) {
        this.accountService = accountService;
        this.clientService = clientService;
        this.transactionsService = transactionsService;

    }

    @GetMapping("/account")
    public ModelAndView createNewAccount() {
        return new ModelAndView("account");
    }

    @PostMapping("/account")
    public ModelAndView registrationNewAccount(Authentication authentication, @ModelAttribute("account") Account account
    ) throws IOException {

        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            Client client = clientService.findByUsername(username);

            if (client != null) {
                String clientId = client.getId();
                accountService.createAccount(account, clientId);
            }
        }
        return new ModelAndView("bank");

    }


    @GetMapping("/addMoney")
    public String addMoney() {
        return "/addMoney";
    }

    @PostMapping("/addMoney")
    public ResponseEntity<String> depositToAccount(@RequestParam(name = "accountNumber") String accountNumber,
                                                   @RequestParam(name = "pin") String pin,
                                                   @RequestParam(name = "balance") BigDecimal balance,
                                                   @RequestParam(name = "transaction_currency") String transaction_currency) {
        try {
            accountService.cashDeposit(accountNumber, pin, balance);

            Transactions transactions = new Transactions();
            transactions.setAccountNumber(accountNumber);
            transactions.setBalance(balance);
            transactions.setTransaction_currency(Currency.valueOf(transaction_currency));


            transactionsService.saveTransactionsReplenishment(transactions);

            return ResponseEntity.ok("Deposit successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/getMoney")
    public String withdrawalFromAccount() {
        return "/getMoney";
    }

    @PostMapping("/getMoney")
    public ResponseEntity<String> withdrawalFromAccount(@RequestParam(name = "accountNumber") String accountNumber,
                                                        @RequestParam(name = "pin") String pin,
                                                        @RequestParam(name = "balance") BigDecimal balance,
                                                        @RequestParam(name = "transaction_currency") String transaction_currency) {
        try {
            accountService.cashWithdrawal(accountNumber, pin, balance);

            Transactions transactions = new Transactions();
            transactions.setAccountNumber(accountNumber);
            transactions.setBalance(balance);
            transactions.setTransaction_currency(Currency.valueOf(transaction_currency));


            transactionsService.saveTransactionsWithdrawal(transactions);

            return ResponseEntity.ok("Withdrawal successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/transferMoney")
    public String transferMoney() {
        return "/transferMoney";
    }

    @PostMapping("/transferMoney")
    public ResponseEntity<String> transferMoney(@RequestParam(name = "accountNumber") String accountNumber,
                                                @RequestParam(name = "accountNumberRecipient") String accountNumberRecipient,
                                                @RequestParam(name = "pin") String pin,
                                                @RequestParam(name = "balance") BigDecimal balance,
                                                @RequestParam(name = "transaction_currency") String transaction_currency) {
        try {
            accountService.cashTransfer(accountNumber, accountNumberRecipient, pin, balance);

            Transactions transactions = new Transactions();
            transactions.setAccountNumber(accountNumber);
            transactions.setAccountNumberRecipient(accountNumberRecipient);
            transactions.setBalance(balance);
            transactions.setTransaction_currency(Currency.valueOf(transaction_currency));


            transactionsService.saveTransactionsTransfer(transactions);

            return ResponseEntity.ok("Transfer successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}







