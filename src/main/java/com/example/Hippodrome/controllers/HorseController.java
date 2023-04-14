package com.example.Hippodrome.controllers;

import com.example.Hippodrome.entities.Horses;
import com.example.Hippodrome.services.HorsesService;
import com.example.Hippodrome.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/horse")
public class HorseController {

    private final HorsesService service;

    private final UsersService usersService;

    @Autowired
    public HorseController(HorsesService service, UsersService usersService) {
        this.service = service;
        this.usersService = usersService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("horses", service.findAll())
                .addAttribute("user", usersService.getUser());
        return "horse/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("horse", new Horses());
        return "horse/create";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("horse")Horses horses) {
        service.save(horses);
        return "redirect:/horse";
    }

}
