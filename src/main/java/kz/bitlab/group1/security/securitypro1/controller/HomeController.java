package kz.bitlab.group1.security.securitypro1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index(Model model) {
        return "main_layout";
    }

    @GetMapping(value = "/signin")
    public String signin(Model model) {
        return "signin";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profile(Model model) {
        return "profile";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/admin-panel")
    public String adminPanel(Model model) {
        return "admin";
    }

    @PreAuthorize("hasAnyRole('ROLE_MODERATOR')")
    @GetMapping(value = "/moderator-panel")
    public String moderatorPanel(Model model) {
        return "moderator";
    }

    @GetMapping(value = "/forbidden")
    public String forbidden(Model model) {
        return "forbidden";
    }
}
