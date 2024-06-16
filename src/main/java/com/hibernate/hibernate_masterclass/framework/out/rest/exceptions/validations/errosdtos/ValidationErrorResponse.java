package com.hibernate.hibernate_masterclass.framework.out.rest.exceptions.validations.errosdtos;

import lombok.Builder;

@Builder
public record ValidationErrorResponse(
        String field,String code, String message) {

}