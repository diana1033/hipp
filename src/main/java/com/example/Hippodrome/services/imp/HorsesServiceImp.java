package com.example.Hippodrome.services.imp;

import com.example.Hippodrome.entities.Horses;
import com.example.Hippodrome.rep.HorsesRepository;
import com.example.Hippodrome.services.HorsesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorsesServiceImp implements HorsesService {

    private HorsesRepository repository;

    @Autowired
    public HorsesServiceImp(HorsesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Horses save(Horses t) {
        return repository.save(t);
    }

    @Override
    public Horses findById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Horses update(Long id, Horses horses) {
        Horses horses1 = findById(id);

        horses1.setName(horses.getName());
        horses1.setDescription(horses.getDescription());

        return save(horses1);
    }

    @Override
    public List<Horses> findAll() {
        return findAll();
    }
}
