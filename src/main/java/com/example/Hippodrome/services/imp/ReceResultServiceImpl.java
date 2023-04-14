package com.example.Hippodrome.services.imp;

import com.example.Hippodrome.entities.RaceResult;
import com.example.Hippodrome.rep.RaceResultRepository;
import com.example.Hippodrome.services.ReceResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceResultServiceImpl implements ReceResultService {

    private final RaceResultRepository repository;

    @Autowired
    public ReceResultServiceImpl(RaceResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public RaceResult save(RaceResult t) {
        return repository.save(t);
    }

    @Override
    public RaceResult findById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public RaceResult update(Long id, RaceResult raceResult) {
        return null;
    }

    @Override
    public List<RaceResult> findAll() {
        return repository.findAll();
    }
}
