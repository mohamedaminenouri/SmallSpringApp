package com.example.tp8nourimohamedaminealinfo06.repsository;

import com.example.tp8nourimohamedaminealinfo06.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe ,Long> {
}
