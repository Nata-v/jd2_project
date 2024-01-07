package by.nata.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@SuppressWarnings({"unused"})
@Controller
public class HomeController {
    @GetMapping({"/", "/index.jsp", "/page.html", "/home"})
    public String getHomePage() {
        return "login";
    }
}

