package com.hibernate.hibernate_masterclass.framework.out.rest.controllers.books;

import com.hibernate.hibernate_masterclass.common.uris.Uris;
import com.hibernate.hibernate_masterclass.domain.usecases.books.UploadBookImageUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.PostExchange;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class UploadBookImageController {
    private final UploadBookImageUseCase uploadBookImageUseCase;

    @PostMapping(Uris.BASE_URL + Uris.BOOKS + "/upload")
    public ResponseEntity<Void> uploadBookImage(@RequestParam("image") MultipartFile image) throws IOException {
        uploadBookImageUseCase.uploadBookImage(image);
        return ResponseEntity.ok().build();
    }
}
