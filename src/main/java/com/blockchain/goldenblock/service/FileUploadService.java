package com.blockchain.goldenblock.service;

import com.blockchain.goldenblock.domain.dto.FileUploadDto;
import com.blockchain.goldenblock.domain.repository.FileUploadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class FileUploadService {
    private final FileUploadRepository fileUploadRepository;

    @Transactional
    public Long saveFile(FileUploadDto fileUploadDto){
        return fileUploadRepository.save(fileUploadDto.toEntity()).getId();
    }
}