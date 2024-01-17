package by.nata.web.controllers;

import by.nata.service.BankomatOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class BankomatOperationsController {

    private final BankomatOperationsService bankomatOperationService;
@Autowired
    public BankomatOperationsController(BankomatOperationsService bankomatOperationService) {
        this.bankomatOperationService = bankomatOperationService;
    }
    @GetMapping("/bankomat")
    public ModelAndView useBankomat(){
        return new ModelAndView("bankomat");
    }
}
