package com.blockchain.goldenblock.domain.dto;

import com.blockchain.goldenblock.domain.entity.File;
import lombok.Builder;

public class FileUploadDto {
    private Long researchId;
    private String fileName;
    private byte[] data;

    @Builder
    public File toEntity() {
        File file = File.builder()
                .researchId(researchId)
                .fileName(fileName)
                .data(data)
                .build();

        return file;
    }
}