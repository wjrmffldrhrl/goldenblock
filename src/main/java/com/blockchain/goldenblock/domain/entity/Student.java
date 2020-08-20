package com.blockchain.goldenblock.domain.entity;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@Table
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String school;

    @Column(length = 30, unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String publicKey;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ResearchStudentMember> students = new ArrayList<>();

    @Builder
    public Student(Long id, String name, String school, String email,
                   String password, String publicKey) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.email = email;
        this.password = password;
        this.publicKey = publicKey;
    }
}