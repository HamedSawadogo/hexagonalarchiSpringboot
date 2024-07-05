package com.hibernate.hibernate_masterclass.framework.out.rest.controllers.books;

import com.hibernate.hibernate_masterclass.common.uris.Uris;
import com.hibernate.hibernate_masterclass.domain.usecases.books.CreateBookUseCase;
import com.hibernate.hibernate_masterclass.framework.out.rest.controllers.books.dtos.BookRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class CreateBookController {

    private final CreateBookUseCase createBookUseCase;
    private final RestTemplate restTemplate  = new RestTemplate();

    @PostMapping(Uris.BASE_URL + Uris.BOOKS)
    public ResponseEntity<Long> createBook(@Validated @RequestBody BookRequestDto bookRequestDto) {
        var bookCreated = createBookUseCase.execute(bookRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookCreated.getId());
    }
}
