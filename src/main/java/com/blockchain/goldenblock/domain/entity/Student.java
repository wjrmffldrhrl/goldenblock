package com.blockchain.goldenblock.domain.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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

    @Column(length = 50, nullable = false)
    private String password;

    @Column(nullable = false)
    private String publicKey;

}