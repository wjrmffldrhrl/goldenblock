package com.blockchain.goldenblock.domain.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "number")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Student {

    @Id @GeneratedValue
    private Long number;

    @Column(unique = true)
    private String id;

    private String password;

    private String name;
    
    private String school;
}