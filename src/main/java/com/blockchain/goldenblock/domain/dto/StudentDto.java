package com.blockchain.goldenblock.domain.dto;

import com.blockchain.goldenblock.domain.entity.Student;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class StudentDto {
    private Long id;
    private String name;
    private String school;
    private String email;
    private String password;

    public Student toEntity(){
        Student student = Student.builder()
                .id(id)
                .name(name)
                .school(school)
                .email(email)
                .password(password)
                .build();
                return student;
    }
    @Builder
    public StudentDto(Long id, String name, String school, String email, String password){
        this.id=id;
        this.email=email;
        this.name=name;
        this.school=school;
        this.password=password;
    }
}
