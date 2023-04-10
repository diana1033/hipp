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
public class Bets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;

    @ManyToOne
    @JoinColumn(name = "horse_id")
    Horses horse;
}
