package com.blockchain.goldenblock.domain.dto;

import com.blockchain.goldenblock.domain.entity.Student;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RankingDto {
    private String email;
    private String name;

    public Student toEntity() {
        Student studentRanking = Student.builder()
                .name(name)
                .email(email)
                .build();

        return studentRanking;
    }
}
