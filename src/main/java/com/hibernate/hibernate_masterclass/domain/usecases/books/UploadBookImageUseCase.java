package com.hibernate.hibernate_masterclass.domain.usecases.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@AllArgsConstructor
public class UploadBookImageUseCase {

    private final String BOOKS_PATH = System.getProperty("user.dir")+"/images";

    public void uploadBookImage(final MultipartFile file) throws IOException {
        var uniqFile = Paths.get(BOOKS_PATH, file.getOriginalFilename());
        System.err.println(uniqFile);
        Files.write(uniqFile, file.getBytes());
    }
}
