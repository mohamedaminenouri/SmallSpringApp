package com.example.tp8nourimohamedaminealinfo06.controller;

import com.example.tp8nourimohamedaminealinfo06.entities.ProjetDetail;
import com.example.tp8nourimohamedaminealinfo06.services.ProjetDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/projetDetail")
public class ProjetDetailController {
  ProjetDetailService projetDetailService;
    @GetMapping("/retrieve-all-projetDetails")
    public List<ProjetDetail> getProjetDetails() {
        List<ProjetDetail> listProjetDetails = projetDetailService.getAll();
        if (listProjetDetails.size()>0){
            return listProjetDetails;
        }
        return listProjetDetails;
    }

    // http://localhost:8089/tpfoyer/projetDetail/retrieve-projetDetail/8
    @GetMapping("/retrieve-projetDetail/{projetDetail-id}")
    public ResponseEntity<Object> retrieveProjetDetail(@PathVariable("projetDetail-id") Long chId) {
        ProjetDetail projetDetail = projetDetailService.getById(chId);
        if (projetDetail !=null){
            return  new ResponseEntity<>(projetDetail, HttpStatus.OK);
        }
        return new ResponseEntity<>("error ",HttpStatus.CONFLICT);
    }

    @PostMapping("/add-projetDetail")
    public ResponseEntity<Object> addProjetDetail(@RequestBody ProjetDetail c) {
        ProjetDetail projetDetail = projetDetailService.Add(c);
        if(projetDetail!=null){
            return new ResponseEntity<>(projetDetail,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(" error ",HttpStatus.CONFLICT);
    }

    @DeleteMapping("/remove-projetDetail/{projetDetail-id}")
    public void removeProjetDetail(@PathVariable("projetDetail-id") Long chId) {
        projetDetailService.deleteById(chId);
    }

    @PutMapping("/modify-projetDetail")
    public ResponseEntity modifyProjetDetail(@RequestBody ProjetDetail c) {
        if  (projetDetailService.Update(c) !=null){
            return new ResponseEntity(projetDetailService.Update(c),HttpStatus.OK);
        }

        return new ResponseEntity("error ",HttpStatus.CONFLICT);
    }


}
