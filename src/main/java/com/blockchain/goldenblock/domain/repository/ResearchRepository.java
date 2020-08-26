package com.blockchain.goldenblock.domain.repository;


import com.blockchain.goldenblock.domain.entity.Research;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearchRepository extends JpaRepository<Research, Long> {
    
}