package com.example.Hippodrome.controllers;

import com.example.Hippodrome.entities.Users;
import com.example.Hippodrome.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UsersService service;

    @Autowired
    public AuthController(UsersService service) {
        this.service = service;
    }

    @GetMapping()
    public String login(){
        return "index";
    }

    @PostMapping("/check")
    public String check(@RequestParam String nickname,@RequestParam String password) {
        if (service.checkNameAndPassword(nickname,password)) {
            return "redirect:/user";
        }else if (nickname.equals("admin") && password.equals("admin")){
            return "redirect:/admin";
        }
        return "redirect:/auth";
    }

}
