package kz.bitlab.group1.security.securitypro1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index(Model model){
        return "index";
    }

    @GetMapping(value = "/signin")
    public String signin(Model model){
        return "signin";
    }

    @GetMapping(value = "/profile")
    public String profile(Model model){
        return "profile";
    }
}
