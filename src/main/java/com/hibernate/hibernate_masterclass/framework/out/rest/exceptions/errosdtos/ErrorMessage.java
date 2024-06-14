package com.hibernate.hibernate_masterclass.framework.out.rest.exceptions.errosdtos;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorMessage(String message,
                    int code, 
                    LocalDateTime timestamp
) {
     

}