package com.example.Hippodrome.rep;

import com.example.Hippodrome.entities.Bets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetsRepository extends JpaRepository<Bets,Long> {
}
