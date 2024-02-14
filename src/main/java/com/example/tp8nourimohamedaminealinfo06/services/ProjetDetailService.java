package com.example.tp8nourimohamedaminealinfo06.services;

import com.example.tp8nourimohamedaminealinfo06.entities.ProjetDetail;

import java.util.List;

public interface ProjetDetailService {
   ProjetDetail Add(ProjetDetail p);
   ProjetDetail getById(Long id);
   List<ProjetDetail> getAll();
  void deleteById(Long id);
  ProjetDetail Update(ProjetDetail projetDetailDetails);
}
