package com.example.Hippodrome.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Horses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name, description;

    @ManyToOne
    Race race;

}
