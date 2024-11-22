package com.fabian_velasquez.satyro_backend.application.dto.request;

import lombok.Data;

@Data
public class PaginatedEventRequest {

    private Integer page;
    private Integer size;
}
