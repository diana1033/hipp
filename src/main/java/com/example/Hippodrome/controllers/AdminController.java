package com.example.Hippodrome.controllers;

import com.example.Hippodrome.entities.Horses;
import com.example.Hippodrome.entities.Race;
import com.example.Hippodrome.services.AdminService;
import com.example.Hippodrome.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService service;
    private final UsersService usersService;

    @Autowired
    public AdminController(AdminService service, UsersService usersService) {
        this.service = service;
        this.usersService = usersService;
    }

    @GetMapping
    public String index() {
        return "admin/index";
    }

    @GetMapping("/getAll")
    public String showHorse(Model model) {
        model.addAttribute("horses", service.getAll())
                .addAttribute("user", usersService.getUser());
        return "horse/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("horse", service.findHorseById(id));
        return "horse/edit";
    }

    @PutMapping("/{id}")
    public String update(@ModelAttribute("horse")Horses horses, @PathVariable("id") Long id) {
        service.updateHorseData(id, horses);
        return "redirect:/admin";
    }


    @GetMapping("/createRace")
    public String createRace(Model model) {
        model.addAttribute("race", new Race());
        return "race/createFrom";
    }

    @PostMapping("/add")
    public String createRace(@ModelAttribute("race") Race race) {
        service.createRace(race);
        return "redirect:/admin";
    }

    @GetMapping("/allRace")
    public String allRace(Model model) {
        model.addAttribute("races", service.getAllRace())
                .addAttribute("user", usersService.getUser());
        return "race/index";
    }

    @PutMapping("/start/{id}")
    public String startRace(@PathVariable("id") Long id) {
        service.startRace(id);
        return "redirect:/admin";
    }
}
