package com.hibernate.hibernate_masterclass.framework.out.rest.exceptions;

import com.hibernate.hibernate_masterclass.framework.out.rest.exceptions.validations.errosdtos.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@ControllerAdvice
public class GlobalExceptionManager {

//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<ErrorMessage>  resourceNotFoundException(Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(new ErrorMessage(e.getMessage(),
//                HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now()));
//    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<List<ValidationErrorResponse>> methodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        List<ValidationErrorResponse> errors = new ArrayList<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errors.add(new ValidationErrorResponse(fieldError.getField(),
                    fieldError.getCode(), fieldError.getDefaultMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }



}
