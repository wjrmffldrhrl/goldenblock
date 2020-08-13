package com.blockchain.goldenblock.domain.repository;

import com.blockchain.goldenblock.domain.entity.Enterprise;

import com.blockchain.goldenblock.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    Enterprise findByName(String name);
    Enterprise findByEmail(String email);
    boolean existsByEmail(String email);
}