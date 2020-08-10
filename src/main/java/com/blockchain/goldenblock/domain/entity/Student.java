package com.blockchain.goldenblock.domain.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Builder @EqualsAndHashCode(of = "id")
@Table(name="Student")
public class Student {
    
    @Id @GeneratedValue
    private Long id;


    @Column(length=20, nullable = false)
    private String name;

    @Column(length=20, nullable = false)
    private String school;

    @Column(length = 30, unique = true, nullable = false)
    private String email;


    @Column(length=50 , nullable = false)
    private String password;

    @Builder
    public Student(Long id, String name, String school, String email, String password){
        this.id=id;
        this.name=name;
        this.school=school;
        this.email=email;
        this.password=password;
    }
}