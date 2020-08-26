package com.blockchain.goldenblock.domain.dto;

import com.blockchain.goldenblock.domain.entity.Enterprise;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class EnterpriseDto {
    private String name;
    private String ph;
    private String email;
    private String companyNumber;
    private String password;

    @Builder
    public Enterprise toEntity() {
        Enterprise enterprise = Enterprise.builder()
                .name(name)
                .ph(ph)
                .email(email)
                .companyNumber(companyNumber)
                .password(password)
                .build();

        return enterprise;
    }
    @Builder
    public EnterpriseDto(String name, String ph, String email, String companyNumber, String password) {

        this.name = name;
        this.ph = ph;
        this.email = email;
        this.companyNumber = companyNumber;
        this.password = password;

    }
}