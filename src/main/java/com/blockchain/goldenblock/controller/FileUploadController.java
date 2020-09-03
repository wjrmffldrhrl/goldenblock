package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.domain.dto.FileUploadDto;
import com.blockchain.goldenblock.service.FileUploadService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@CrossOrigin
@AllArgsConstructor
public class FileUploadController {
    private FileUploadService fileUploadService;

    @PostMapping("/fileupload")
    public void postFile(@RequestBody FileUploadDto fileUploadDto){
        fileUploadService.saveFile(fileUploadDto);
    }
}
