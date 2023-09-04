package com.example.librarymanagementsystem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @PreAuthorize("!isAuthenticated()")
    @RequestMapping("/login")
    public String getLoginPage() {
        return "login";
    }

}
