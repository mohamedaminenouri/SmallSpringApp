package com.example.tp8nourimohamedaminealinfo06.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nom;
    @Enumerated(EnumType.STRING)
    private domaine Domaine;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ToString.Exclude
     private Set<Projet> projets;
}
