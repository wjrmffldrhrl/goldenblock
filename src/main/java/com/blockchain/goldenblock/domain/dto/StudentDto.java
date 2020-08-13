package com.blockchain.goldenblock.domain.dto;

import com.blockchain.goldenblock.domain.entity.Student;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor

public class StudentDto {
    private String name;
    private String school;
    private String email;
    private String password;
    private String publicKey;

    @Builder
    public Student toEntity() {
        Student student = Student.builder()
                .name(name)
                .school(school)
                .email(email)
                .password(password)
                .publicKey(publicKey)
                .build();
        return student;
    }
}
