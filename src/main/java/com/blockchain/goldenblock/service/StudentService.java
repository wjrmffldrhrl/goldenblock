package com.blockchain.goldenblock.service;

import com.blockchain.goldenblock.controller.MemberController;
import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.domain.entity.Student;
import com.blockchain.goldenblock.domain.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long saveStudent(StudentDto studentDto) {
        System.out.println(studentDto.getPassword());
        studentDto.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        Student studentDto1 = studentRepository.findByEmail(studentDto.getEmail());
        if(studentDto1!=null){
            throw new MemberController.AlreadyExistsException("m");
        }
        return studentRepository.save(studentDto.toEntity()).getId();
    }


}
