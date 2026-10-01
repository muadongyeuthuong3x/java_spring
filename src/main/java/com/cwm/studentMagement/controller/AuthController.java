package com.cwm.studentMagement.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class AuthController {
    public String login;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
}
