package com.blockchain.goldenblock.domain.dto;


import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InfoDto {

    private String name;
    private String ph;
    private String email;
    private String companyNumber;

    private String school;
    private String rank;

    private String userRole;
}
