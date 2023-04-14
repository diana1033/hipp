package com.example.Hippodrome.services;

import com.example.Hippodrome.entities.Horses;
import com.example.Hippodrome.entities.Race;

import java.util.List;

public interface AdminService {

    List<Horses> getAll();
    Horses findHorseById(Long id);
    Horses updateHorseData(Long id, Horses horses);
    void createRace(Race race);
    List<Race> getAllRace();
    void startRace(Long id);
}
