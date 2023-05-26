package com.example.billsledger.expenses.controller;

import com.example.billsledger.expenses.model.entity.File;
import com.example.billsledger.expenses.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@RestController
public class FileController {
    private final FileService service;

    @PostMapping("/save-file")
    private File uploadFile(@RequestParam("image") MultipartFile file) throws IOException {
        File uploadImage = service.saveFile(file);
        return uploadImage;
    }

    @GetMapping("/get-file/{id}")
    private ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        ResponseEntity<byte[]> insertFile = service.getFile(id);
        return insertFile;
    }
}

