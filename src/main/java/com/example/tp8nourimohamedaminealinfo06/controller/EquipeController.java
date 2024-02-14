package com.example.tp8nourimohamedaminealinfo06.controller;

import com.example.tp8nourimohamedaminealinfo06.entities.Equipe;
import com.example.tp8nourimohamedaminealinfo06.services.EquipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name=" le service ceci concerne   pour lequipe ")
@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {
  EquipeService equipeService;
  @Operation(description=" cette method concerné pour tous les équipes qu'ont existe dans mon projet ")
    @GetMapping("/retrieve-all-equipes")
    public List<Equipe> getEquipes() {
        List<Equipe> listEquipes = equipeService.getAll();
        if (listEquipes.size()>0){
            return listEquipes;
        }
        return listEquipes;
    }

    // http://localhost:8089/tpfoyer/equipe/retrieve-equipe/8
    @GetMapping("/retrieve-equipe/{equipe-id}")
    public ResponseEntity<Object> retrieveEquipe(@PathVariable("equipe-id") Long chId) {
        Equipe equipe = equipeService.getById(chId);
        if (equipe !=null){
            return  new ResponseEntity<>(equipe, HttpStatus.OK);
        }
        return new ResponseEntity<>("error ",HttpStatus.CONFLICT);
    }

    @PostMapping("/add-equipe")
    public ResponseEntity<Object> addEquipe(@RequestBody Equipe c) {
        Equipe equipe = equipeService.Add(c);
        if(equipe!=null){
            return new ResponseEntity<>(equipe,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(" error ",HttpStatus.CONFLICT);
    }

    @DeleteMapping("/remove-equipe/{equipe-id}")
    public void removeEquipe(@PathVariable("equipe-id") Long chId) {
        equipeService.deleteById(chId);
    }

    @PutMapping("/modify-equipe")
    public ResponseEntity modifyEquipe(@RequestBody Equipe c) {
        if  (equipeService.Update(c) !=null){
            return new ResponseEntity(equipeService.Update(c),HttpStatus.OK);
        }

        return new ResponseEntity("error ",HttpStatus.CONFLICT);
    }


}
