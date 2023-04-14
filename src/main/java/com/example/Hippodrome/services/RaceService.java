package com.example.Hippodrome.services;

import com.example.Hippodrome.entities.Race;

public interface RaceService extends BaseService<Race> {

    void startRace(Long id);
}
