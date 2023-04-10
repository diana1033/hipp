package com.example.Hippodrome.controllers;

import com.example.Hippodrome.entities.Users;
import com.example.Hippodrome.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reg")
public class RegContoller {

    private final UsersService service;

    @Autowired
    public RegContoller(UsersService service) {
        this.service = service;
    }

    @GetMapping("/main")
    public String login(Model model){
        model.addAttribute("user", new Users());
        return "reg";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("user")Users users) {
        service.save(users);
        return "redirect:/auth";
    }
}