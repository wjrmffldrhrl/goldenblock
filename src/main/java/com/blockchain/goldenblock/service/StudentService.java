package com.blockchain.goldenblock.service;

import com.blockchain.goldenblock.controller.MemberController;
import com.blockchain.goldenblock.domain.dto.EnterpriseDto;
import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.domain.entity.Student;
import com.blockchain.goldenblock.domain.repository.EnterpriseRepository;
import com.blockchain.goldenblock.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final PasswordEncoder passwordEncoder;


    public Long saveStudent(StudentDto studentDto) {

        boolean isExistStudent = studentRepository.existsByEmail(studentDto.getEmail());
        boolean isExistEnterprise = enterpriseRepository.existsByEmail(studentDto.getEmail());
        studentDto.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        if (isExistStudent || isExistEnterprise) {
            throw new MemberController.AlreadyExistsException("change_email");
        }
        return studentRepository.save(studentDto.toEntity()).getId();
    }

    public Student getStudent(String email) {

        return studentRepository.findByEmail(email);

    }

}