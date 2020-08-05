package com.blockchain.goldenblock.domain.repository;

import com.blockchain.goldenblock.domain.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{

    Student findById(String id);
    Student findByNumber(Long number);
}