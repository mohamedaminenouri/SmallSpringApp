package com.example.tp8nourimohamedaminealinfo06.services;

import com.example.tp8nourimohamedaminealinfo06.entities.ProjetDetail;
import com.example.tp8nourimohamedaminealinfo06.repsository.ProjetDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class projetDetailServiceImpl implements ProjetDetailService {
   ProjetDetailRepository projetDetailRepository;

    @Override
    public ProjetDetail Add(ProjetDetail p) {
        return projetDetailRepository.save(p);
    }

    @Override
    public ProjetDetail getById(Long id) {
        return projetDetailRepository.findById(id).get();
    }

    @Override
    public List<ProjetDetail> getAll() {
        return projetDetailRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
      projetDetailRepository.deleteById(id);
    }

    @Override
    public ProjetDetail Update(ProjetDetail p) {
        return projetDetailRepository.save(p);
    }
}
