package com.example.tp8nourimohamedaminealinfo06.services;

import com.example.tp8nourimohamedaminealinfo06.entities.Equipe;
import com.example.tp8nourimohamedaminealinfo06.entities.Projet;
import com.example.tp8nourimohamedaminealinfo06.entities.ProjetDetail;
import com.example.tp8nourimohamedaminealinfo06.repsository.EquipeRepository;
import com.example.tp8nourimohamedaminealinfo06.repsository.ProjetDetailRepository;
import com.example.tp8nourimohamedaminealinfo06.repsository.ProjetRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

// le AllArgsConstructor elle remplace le Autowired
@Service
@AllArgsConstructor
@Slf4j
public class projetServiceImpl implements ProjetService {
    ProjetRepository projetRepository;
    ProjetDetailRepository projetDetailRepository;
    EquipeRepository equipeRepository;

    @Override
    public Projet Add(Projet p) {
        return projetRepository.save(p);
    }

    @Override
    public Projet getById(Long id) {
        return projetRepository.findById(id).get();
    }
 // pour executer cette méthode pour chaque 10000 s
    @Scheduled(fixedRate = 10000)
  //  @Scheduled(fixedDelay = 10000) apres le finir de la derniere instruction
    @Override
    public List<Projet> getAll() {
        List<Projet> projets=projetRepository.findAll();
        log.info(" nbre projet  :"+projets.size());

        return projets;
    }

    @Override
    public void deleteById(Long id) {
        projetRepository.deleteById(id);
    }

    @Override
    public Projet Update(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId).get();
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
        // on set le fils dans le parent :

        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }

    @Override
    public void UnassignProjetDetailToProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId).get();
        // on set le fils dans le parent :

        projet.setProjetDetail(null);
        projetRepository.save(projet);
    }

    @Override
    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();

        if (projet != null && equipe != null) {
            equipe.getProjets().add(projet);
            equipeRepository.save(equipe);

        }
    }

    @Override
    public void assingProjetDetailToNewProjet(Long projetDetail, Projet p) {
        ProjetDetail projetDetail1=projetDetailRepository.findById(projetDetail).get();
        p.setProjetDetail(projetDetail1);
        projetRepository.save(p);
    }

    @Override
    public void UnassignProjetFromEquipe(Long projetId,Long equipeId) {
        Projet p = projetRepository.findById(projetId).get();
        Equipe e = equipeRepository.findById(equipeId).get();
        e.getProjets().remove(p);
        equipeRepository.save(e);
    }

}
