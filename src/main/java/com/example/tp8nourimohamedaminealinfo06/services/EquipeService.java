package com.example.tp8nourimohamedaminealinfo06.services;

import com.example.tp8nourimohamedaminealinfo06.entities.Equipe;

import java.util.List;

public interface EquipeService {
   Equipe Add(Equipe  p);
   Equipe getById(Long id);
   List<Equipe> getAll();
  void deleteById(Long id);
  Equipe Update(Equipe equipe);
}
