package by.nata.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//@RestController
//@RequestMapping("/web/messages")
public class LanguageController {
   // @Autowired
//    private final MessageSource messageSource;
//
//    public LanguageController(MessageSource messageSource) {
//        this.messageSource = messageSource;
//    }

   // @GetMapping("/change-language")
//    @GetMapping
//    public String changeLanguage(@RequestParam("key") String key,
//                                 @RequestParam("lang") String language){
////        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
////        localeResolver.setLocale(request, null, new Locale(language));
//        return messageSource.getMessage(key, null, null, new Locale(language));
//    }
    //    @PostMapping("/login")
//    public String home(@RequestParam(name = "lang", required = false) String lang, Model model, Locale locale) {
//        if (lang != null) {
//            locale = new Locale(lang);
//        }
//
//        String greetingMessage = messageSource.getMessage("greeting.message", null, locale);
//        model.addAttribute("greetingMessage", greetingMessage);
//
//        return "login";
//    }
}
