package com.blockchain.goldenblock.domain.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table
@Builder
@AllArgsConstructor
public class Enterprise {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String ph;

    @Column(length = 30, unique = true, nullable = false)
    private String email;

    @Column(length = 30, nullable = false)
    private String companyNumber;

    @Column(nullable = false)
    private String password;

    private String publicKey;



}