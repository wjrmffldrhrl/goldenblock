package com.blockchain.goldenblock.domain.model;

import java.util.List;

import com.blockchain.goldenblock.domain.entity.Student;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class StudentDetails extends User {
    private Student student;
    // 스프링 시큐리티가 다루는 유저 정보를 우리가 가지고 있는 도메인의 유저 정보와 연동
    public StudentDetails(Student student) {
        super(student.getId(), student.getPassword(), List.of(new SimpleGrantedAuthority("STUDENT")));
        this.student = student;
    }
}