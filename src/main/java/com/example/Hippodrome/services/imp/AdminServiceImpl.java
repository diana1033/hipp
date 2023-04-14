package com.example.Hippodrome.services.imp;

import com.example.Hippodrome.entities.Horses;
import com.example.Hippodrome.entities.Race;
import com.example.Hippodrome.services.AdminService;
import com.example.Hippodrome.services.HorsesService;
import com.example.Hippodrome.services.RaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final HorsesService service;
    private final RaceService raceService;

    public AdminServiceImpl(HorsesService service, RaceService raceService) {
        this.service = service;
        this.raceService = raceService;
    }

    @Override
    public Horses updateHorseData(Long id, Horses horses){
        return service.update(id, horses);
    }

    @Override
    public void createRace(Race race) {
        raceService.save(race);
    }

    @Override
    public List<Race> getAllRace() {
        return raceService.findAll();
    }

    @Override
    public void startRace(Long id) {
        raceService.startRace(id);
    }

    @Override
    public Race findRaceById(Long id) {
        return raceService.findById(id);
    }

    @Override
    public void addHorseToRace(Long idHorse, Long idRace) {
        Horses horses = service.findById(idHorse);
        horses.setRace(raceService.findById(idRace));
        service.save(horses);
    }


    @Override
    public List<Horses> getAll() {
        return service.findAll();
    }

    @Override
    public Horses findHorseById(Long id) {
        return service.findById(id);
    }


}
