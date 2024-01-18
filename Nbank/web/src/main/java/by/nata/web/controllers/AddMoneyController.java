package by.nata.web.controllers;

import by.nata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
@RestController
@RequestMapping("/addMoney")
public class AddMoneyController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/addMoney")
    public ResponseEntity<String> depositToAccount(@RequestParam String accountNumber,
                                                   @RequestParam String pin,
                                                   @RequestParam BigDecimal balance) {
        try {
            accountService.cashDeposit(accountNumber, pin, balance);
            return ResponseEntity.ok("Deposit successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
