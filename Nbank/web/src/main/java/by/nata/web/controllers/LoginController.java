package by.nata.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@SuppressWarnings({"unused"})
public class LoginController {


    @GetMapping({"/", "/login"})
    public String getHomePage() {
        return "login";
    }


    @GetMapping("/info")
    public String goToInfo(){
        return "info";
    }

    @PostMapping("/login")
    public String login(){
        return "redirect:/bank";
    }


    @Secured({"ADMIN", "USER"})
    @GetMapping("/bank")
    public String goToMainPage(Authentication authentication, Model model){

        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String getUsernameFromSecurity = userDetails.getUsername();
            model.addAttribute("username", getUsernameFromSecurity);
        }
        return "bank";
    }
    @GetMapping("/bankomat")
    public ModelAndView useBankomat(){
        return new ModelAndView("bankomat");
    }



}
