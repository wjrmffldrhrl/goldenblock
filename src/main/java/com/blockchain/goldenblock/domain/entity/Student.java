package com.blockchain.goldenblock.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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