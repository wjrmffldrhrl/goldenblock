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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder @EqualsAndHashCode(of = "id")
public class Enterprise {
    
    @Id @GeneratedValue
    Long id;

    @Column(unique = true)
    String name;
    
    String ph;

    String email;

    String companyNumber;

    String password;

}