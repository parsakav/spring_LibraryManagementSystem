package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Role;
import com.example.librarymanagementsystem.model.User;
import com.example.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Controller
@PreAuthorize("!isAuthenticated()")
public class SignupController {
    private final  UserService userService;
    @Lazy
   private final AuthenticationManager authManager;

    @Autowired
    public SignupController(UserService userService, AuthenticationManager authManager) {
        this.userService = userService;
        this.authManager = authManager;
    }

    @PreAuthorize("!isAuthenticated()")
    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";
    }

    @PostMapping("/signup/adduser")

    public String addUser(@RequestParam String username, @RequestParam String password, Model model, HttpServletRequest request) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Set<Role> ms = new HashSet<>();
        Role r = new Role();
        r.setId(Roles.ROLE_USER);
        r.setName(Roles.ROLE_1);
        ms.add(r);
        user.setRoles(ms);
        try {
            userService.saveUser(user);


            authWithAuthManager(request, username, password);
            model.addAttribute("singupok", "true");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
            return "error";
        }
        return "signup";
    }

    public void authWithAuthManager(HttpServletRequest request, String username, String password) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        authToken.setDetails(new WebAuthenticationDetails(request));

        Authentication authentication = authManager.authenticate(authToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public static class Roles {
        public static final int ROLE_USER = 1;
        public static final int ROLE_ADMIN = 2;
        public static final int ROLE_PUBLISHER = 3;

        public static final String ROLE_1 = "ROLE_USER";
        public static final String ROLE_2 = "ROLE_ADMIN";
        public static final String ROLE_3 = "ROLE_PUBLISHER";
    }

}