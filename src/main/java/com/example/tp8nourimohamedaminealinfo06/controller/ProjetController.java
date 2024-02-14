package com.example.tp8nourimohamedaminealinfo06.controller;

import com.example.tp8nourimohamedaminealinfo06.entities.Projet;
import com.example.tp8nourimohamedaminealinfo06.services.ProjetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class ProjetController {
     ProjetService projetService;
    @GetMapping("/retrieve-all-projets")
    public List<Projet> getProjets() {
        List<Projet> listProjets = projetService.getAll();
        if (listProjets.size()>0){
            return listProjets;
        }
        return listProjets;
    }

    // http://localhost:8089/tpfoyer/projet/retrieve-projet/8
    @GetMapping("/retrieve-projet/{projet-id}")
    public ResponseEntity<Object> retrieveProjet(@PathVariable("projet-id") Long chId) {
        Projet projet = projetService.getById(chId);
        if (projet !=null){
            return  new ResponseEntity<>(projet, HttpStatus.OK);
        }
        return new ResponseEntity<>("error ",HttpStatus.CONFLICT);
    }

    @PostMapping("/add-projet")
    public ResponseEntity<Object> addProjet(@RequestBody Projet c) {
        Projet projet = projetService.Add(c);
        if(projet!=null){
            return new ResponseEntity<>(projet,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(" error ",HttpStatus.CONFLICT);
    }

    @DeleteMapping("/remove-projet/{projet-id}")
    public void removeProjet(@PathVariable("projet-id") Long chId) {
        projetService.deleteById(chId);
    }

    @PutMapping("/modify-projet")

    public ResponseEntity modifyProjet(@RequestBody Projet c) {
        if  (projetService.Update(c) !=null){
            return new ResponseEntity(projetService.Update(c),HttpStatus.OK);
        }

        return new ResponseEntity("error ",HttpStatus.CONFLICT);
    }
// on a affecter le projet pour le projetDetail correspond
    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void affecterProjetAProjetDetail(@PathVariable("projet-id") Long proejtId,
                                             @PathVariable("projet-details-id") Long proejtDetailsId) {
        projetService.assignProjetDetailToProjet(proejtId, proejtDetailsId);
    }

   @PutMapping("/desaffecter-projet-de-projet-details/{projet-id}")
    public void dsaffecterProjetAProjetDetail(@PathVariable("projet-id") Long proejtId)
                                             {
        projetService.UnassignProjetDetailToProjet(proejtId);
              System.out.println("desafecter");
    }
    // on a affecter le projet pour le projetDetail correspond
    @PutMapping("/affecter-projet-a-equipe/{projet-id}/{equipe-id}")
    public void affecterProjetAEquipe(@PathVariable("projet-id") Long proejtId,
                                            @PathVariable("equipe-id") Long equipeID) {
        projetService.assignProjetToEquipe(proejtId, equipeID);
        System.out.println("affectation ... ");
    }

    // on a affecter  le projetDetail  a un nouveaux projet correspond
    @PutMapping("/ affecterProjetDetail_A Nouveaux_Projet/{projetDetail-id}")
    public void affecterProjetAProjetDetail(@PathVariable("projet") Projet projet,
                                      @PathVariable("projetDetail-id") Long projetDetailID) {
        projetService.assingProjetDetailToNewProjet( projetDetailID,projet);
        System.out.println("affectation ... ");
    }
    // on a affecter  le projet  a un equipe correspond
    @PutMapping("/ desaffecter/{projet-id}/{equipe-id}")
    public void desaffecterProjetAEquipe(@PathVariable("projet-id") Long projetID,
                                            @PathVariable("equipe-id") Long equipeID) {
        projetService.UnassignProjetFromEquipe( projetID,equipeID);
        System.out.println("Desaffectation ... ");
    }
}
