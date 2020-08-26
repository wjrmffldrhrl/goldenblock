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
    private String title;
    private String content;
    private String prizeMoney;
    private LocalDate deadLine;
    private String status;
    private String companyName;


    public Research toEntity() {
        Research research  = Research.builder()
                .id(id)
                .title(title)
                .content(content)
                .prizeMoney(prizeMoney)
                .deadLine(deadLine)
                .status(status)
                .companyName(companyName)
                .build();

        return research;
    }

}
