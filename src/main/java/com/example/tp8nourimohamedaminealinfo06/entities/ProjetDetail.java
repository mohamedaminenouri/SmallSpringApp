package com.example.tp8nourimohamedaminealinfo06.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjetDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private  String technologie;
    private Long cout;
    private Date dateDebut;
    @OneToOne(mappedBy = "projetDetail")
    // on met le jsonIgnore pourque lorsque on getAll projet detail pour eviter (le boucle d'appel projet par projetDetail )
    @JsonIgnore
    private Projet projet;




}
