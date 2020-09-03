package com.blockchain.goldenblock.domain.dto;

import com.blockchain.goldenblock.domain.entity.Enterprise;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
}