package com.example.Hippodrome.services.imp;

import com.example.Hippodrome.entities.Horses;
import com.example.Hippodrome.entities.Race;
import com.example.Hippodrome.entities.RaceResult;
import com.example.Hippodrome.rep.RaceRepository;
import com.example.Hippodrome.services.HorsesService;
import com.example.Hippodrome.services.RaceService;
import com.example.Hippodrome.services.ReceResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RaceServiceImpl implements RaceService {

    private final HorsesService service;
    private final RaceRepository repository;
    private final ReceResultService receResultService;
    private Race saveRace;


    @Autowired
    public RaceServiceImpl(HorsesService service, RaceRepository repository, ReceResultService receResultService) {
        this.service = service;
        this.repository = repository;
        this.receResultService = receResultService;
    }


    @Override
    public Race save(Race t) {
        return repository.save(t);
    }

    @Override
    public Race findById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Race update(Long id, Race race) {
        return null;
    }

    @Override
    public List<Race> findAll() {
        return repository.findAll();
    }

    @Override
    public void startRace(Long id) {
        Race race = findById(id);
        race.setStatus(true);
        List<Horses> list = service.findAll();
        Collections.shuffle(list);

        RaceResult result = new RaceResult();
        result.setRace(race);
        result.setHorses(list.get(0));
        receResultService.save(result);
        for (Horses horse: list) {
            horse.setRace(null);
        }
        save(race);
    }

    @Override
    public Race getRace() {
        return this.saveRace;
    }

    @Override
    public void setRace(Long id) {
        saveRace = findById(id);
    }
}
