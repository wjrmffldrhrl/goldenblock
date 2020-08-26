package com.blockchain.goldenblock.domain.dto;

import com.blockchain.goldenblock.domain.entity.Research;
import lombok.*;
import java.time.LocalDate;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResearchDto {
    private Long id;
    private String researchTitle;
    private String researchContent;
    private String prizeMoney;
    private LocalDate deadLine;
    private String researchStatus;
    private String companyName;


    public Research toEntity() {
        Research research  = Research.builder()
                .id(id)
                .researchTitle(researchTitle)
                .researchContent(researchContent)
                .prizeMoney(prizeMoney)
                .deadLine(deadLine)
                .researchStatus(researchStatus)
                .companyName(companyName)
                .build();

        return research;
    }

}
