package com.blockchain.goldenblock.domain.repository;


import com.blockchain.goldenblock.domain.entity.Research;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResearchRepository extends JpaRepository<Research, Long> {

    Optional<Research> findById(Long id);
}