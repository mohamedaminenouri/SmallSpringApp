package com.example.tp8nourimohamedaminealinfo06.services;

import com.example.tp8nourimohamedaminealinfo06.entities.Equipe;
import com.example.tp8nourimohamedaminealinfo06.repsository.EquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class equipeServiceImpl implements EquipeService {
    EquipeRepository  equipeRepository;
    @Override
    public Equipe Add(Equipe p) {
        return equipeRepository.save(p);
    }

    @Override
    public Equipe getById(Long id) {
        return equipeRepository.findById(id).get();
    }

    @Override
    public List<Equipe> getAll() {
        return equipeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
         equipeRepository.deleteById(id);
    }

    @Override
    public Equipe Update(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

}
