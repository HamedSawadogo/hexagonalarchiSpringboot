package com.hibernate.hibernate_masterclass.framework.out.rest.exceptions;

import com.hibernate.hibernate_masterclass.framework.out.rest.exceptions.errosdtos.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@ControllerAdvice
public class GlobalExceptionManager {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorMessage>  resourceNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage(e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now()));
    }



}
