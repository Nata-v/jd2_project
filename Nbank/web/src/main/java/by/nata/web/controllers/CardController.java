package by.nata.web.controllers;

import by.nata.service.AccountService;
import by.nata.service.CardService;
import by.nata.service.model.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@Slf4j
@SuppressWarnings({"unused"})
public class CardController {

    private final CardService cardService;
    private final AccountService accountService;

    @Autowired
    public CardController(CardService cardService, AccountService accountService) {
        this.cardService = cardService;
        this.accountService = accountService;
    }

    @GetMapping("/createCard")
    public ModelAndView oderCard() {
        return new ModelAndView("createCard");
    }

    @PostMapping("/createCard")
    public ModelAndView orderCard(@ModelAttribute("card") Card card, @RequestParam("accountNumber") String accountNumber) throws IOException {

        cardService.createCard(card, accountNumber);

        return new ModelAndView("bank");
    }


}
