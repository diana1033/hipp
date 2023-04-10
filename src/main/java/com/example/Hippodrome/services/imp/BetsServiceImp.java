package com.example.Hippodrome.services.imp;

import com.example.Hippodrome.entities.Bets;
import com.example.Hippodrome.rep.BetsRepository;
import com.example.Hippodrome.services.BetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetsServiceImp implements BetsService {

    private BetsRepository repository;

    @Autowired
    public BetsServiceImp(BetsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bets save(Bets t) {
        return repository.save(t);
    }

    @Override
    public Bets findById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Bets update(Long id, Bets bets) {
        Bets bets1 = findById(id);

        bets1.setAmount(bets1.getAmount());
        bets1.setHorse(bets1.getHorse());
        bets1.setUser(bets1.getUser());

        return bets1;
    }

    @Override
    public List<Bets> findAll() {
        return findAll();
    }
}
