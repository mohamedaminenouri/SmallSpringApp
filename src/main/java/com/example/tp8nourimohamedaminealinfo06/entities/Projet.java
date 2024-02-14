package com.example.tp8nourimohamedaminealinfo06.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
// le cascade doit etre dans le parent au dessus de fils
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sujet;

   @ToString.Exclude

   @OneToOne (cascade = CascadeType.ALL)
   private  ProjetDetail projetDetail;
   // cascade  pour les updates et fetch pour la recuperation





   @ManyToMany(mappedBy = "projets" ,fetch = FetchType.LAZY)
   @ToString.Exclude
   @JsonIgnore
   private Set<Equipe> equipeSet;

}
