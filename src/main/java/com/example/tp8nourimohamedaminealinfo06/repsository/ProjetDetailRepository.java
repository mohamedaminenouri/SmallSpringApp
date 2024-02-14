package com.example.tp8nourimohamedaminealinfo06.repsository;

import com.example.tp8nourimohamedaminealinfo06.entities.ProjetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetDetailRepository extends JpaRepository<ProjetDetail,Long> {
}
