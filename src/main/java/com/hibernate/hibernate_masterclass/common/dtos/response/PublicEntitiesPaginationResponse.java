package com.hibernate.hibernate_masterclass.common.dtos.response;

import lombok.Builder;

import java.util.List;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@Builder
public record PublicEntitiesPaginationResponse<T>(
        List<T> items,
        int page,
        int limit,
        Long totalItems,
        int totalPages
) {
}
