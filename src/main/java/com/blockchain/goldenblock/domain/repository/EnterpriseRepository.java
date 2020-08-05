package com.blockchain.goldenblock.domain.repository;

import com.blockchain.goldenblock.domain.entity.Enterprise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long>{
    
}