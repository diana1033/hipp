package com.example.Hippodrome.rep;

import com.example.Hippodrome.entities.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult,Long> {
}
