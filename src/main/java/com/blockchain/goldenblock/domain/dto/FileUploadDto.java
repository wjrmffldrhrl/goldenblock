package com.blockchain.goldenblock.domain.dto;

import com.blockchain.goldenblock.domain.entity.File;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadDto {
    private Long researchId;
    private String fileName;
    private String data;

    @Builder
    public File toEntity() {
        File file = File.builder()
                .researchId(researchId)
                .fileName(fileName)
                .data(data.getBytes())
                .build();

        return file;
    }
}