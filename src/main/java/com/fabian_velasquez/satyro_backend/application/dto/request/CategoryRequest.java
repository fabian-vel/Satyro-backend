package com.fabian_velasquez.satyro_backend.application.dto.request;

import lombok.Data;

@Data
public class CategoryRequest {

    private String id;
    private String name;
    private String description;
    private String state;
}
