package kz.bitlab.group1.security.securitypro1.controller;

import kz.bitlab.group1.security.securitypro1.service.AccountService;
import kz.bitlab.group1.security.securitypro1.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final AccountService accountService;

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

    @GetMapping(value = "/register")
    public String register(@RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_re_password") String rePassword,
                           @RequestParam(name = "user_full_name") String fullName) {
        if (accountService.registerUser(email, password, rePassword, fullName) != null) {
            return "redirect:/register?success";
        }
        return "redirect:/register?error";
    }
}
