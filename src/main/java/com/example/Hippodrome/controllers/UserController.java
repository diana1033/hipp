package com.example.Hippodrome.controllers;

import com.example.Hippodrome.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UsersService service;

    @Autowired
    public UserController(UsersService service) {
        this.service = service;
    }

    @GetMapping("/menu")
    public String menu(Model model){
        return "user/menu";
    }
}
