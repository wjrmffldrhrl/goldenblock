package com.blockchain.goldenblock.domain.entity;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table
@Builder
@AllArgsConstructor

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

    @Column
    private String rank;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ResearchStudentMember> researchStudentMembers = new ArrayList<>();

}