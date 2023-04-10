package com.example.Hippodrome.rep;

import com.example.Hippodrome.entities.Horses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorsesRepository extends JpaRepository<Horses,Long> {
}
