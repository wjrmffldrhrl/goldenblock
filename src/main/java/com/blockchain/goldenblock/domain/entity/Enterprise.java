package com.blockchain.goldenblock.domain.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@Table
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

    @Column(length = 50, nullable = false)
    private String password;

    @Builder
    public Enterprise(Long id, String name, String ph, String email, String companyNumber, String password) {
        this.id = id;
        this.name = name;
        this.ph = ph;
        this.email = email;
        this.companyNumber = companyNumber;
        this.password = password;


    }

}