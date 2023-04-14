package com.example.Hippodrome.services.imp;

import com.example.Hippodrome.entities.Race;
import com.example.Hippodrome.rep.RaceRepository;
import com.example.Hippodrome.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceServiceImpl implements RaceService {

    private final RaceRepository repository;

    @Autowired
    public RaceServiceImpl(RaceRepository repository) {
        this.repository = repository;
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
        save(race);
    }
}
