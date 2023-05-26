package com.example.billsledger.expenses.service;

import com.example.billsledger.expenses.model.entity.File;
import com.example.billsledger.expenses.model.entity.FileCompress;
import com.example.billsledger.expenses.model.entity.FileDecompress;
import com.example.billsledger.expenses.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FileService {
    private final FileRepository fileRepository;

    public File saveFile(MultipartFile file) throws IOException {
        File insertFile = fileRepository.save(File.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .file(FileCompress.compressImage(file.getBytes())).build());
        if (insertFile != null) {
            return insertFile;
        } else {
            return null;
        }
    }

    public ResponseEntity<byte[]> getFile(Long id) {
        Optional<File> optionalFile = fileRepository.findById(id);
        if (optionalFile.isPresent()) {
            File file = optionalFile.get();
            byte[] content = FileDecompress.decompressImage(file.getFile());
            String contentType = file.getType();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(content);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

