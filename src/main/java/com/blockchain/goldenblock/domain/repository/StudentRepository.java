package com.blockchain.goldenblock.domain.repository;

import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.domain.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
    Student findByName(String name);
    Student findByEmail(String email);
    boolean existsByEmail(String email);
    List<Student> findAllByOrderByEmail();
}