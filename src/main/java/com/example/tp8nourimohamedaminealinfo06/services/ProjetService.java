package com.example.tp8nourimohamedaminealinfo06.services;

import com.example.tp8nourimohamedaminealinfo06.entities.Projet;

import java.util.List;

public interface ProjetService {
   Projet Add(Projet  p);
   Projet getById(Long id);
   List<Projet> getAll();
  void deleteById(Long id);
  Projet Update(Projet projet);
  void  assignProjetDetailToProjet(Long projetid,Long  projDetailsId);
  void  UnassignProjetDetailToProjet(Long projetid);
  void assignProjetToEquipe(Long projetId, Long  EquipeId);
  void assingProjetDetailToNewProjet(Long projetDetail,Projet p);
void  UnassignProjetFromEquipe(Long projetId,Long equipeId);
}
