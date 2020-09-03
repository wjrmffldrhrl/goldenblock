package com.blockchain.goldenblock.domain.repository;

import com.blockchain.goldenblock.domain.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<File, Long> {

}