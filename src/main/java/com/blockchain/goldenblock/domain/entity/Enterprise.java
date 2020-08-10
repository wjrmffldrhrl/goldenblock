package com.blockchain.goldenblock.domain.entity;

import javax.persistence.*;

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
@Table(name="Enterprise")
public class Enterprise {
    
    @Id @GeneratedValue
    private Long id;

    
    private String name;
    
    private String ph;

    @Column(unique = true)
    private String email;

    private String companyNumber;

    private String password;

}