package com.saquib.StudentManagement.controller;

import com.saquib.StudentManagement.model.User;
import com.saquib.StudentManagement.service.CustomeUserDetailService;
import com.saquib.StudentManagement.service.JwtService;
import com.saquib.StudentManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserService service;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
       return service.registerUser(user);
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.getToken(user.getUsername());
        } else {
            return "Login Failed";
        }
    }
}
