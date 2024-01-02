package by.nata.web.controllers;

import by.nata.service.model.LoginDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@Slf4j
public class LoginController {
//    @GetMapping("/login")
//    public String loginPage(){
//        return "login";
//    }

    @PostMapping("/login")
    public String login(Model model, @ModelAttribute("login") LoginDto loginDto){
        return "menubank";
    }
}
