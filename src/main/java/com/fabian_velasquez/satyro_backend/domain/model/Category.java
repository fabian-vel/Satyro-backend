package com.fabian_velasquez.satyro_backend.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class Category {

    private String id;
    private String name;
    private String description;
    private String state;
    private Date createdAt;
    private Date updatedAt;
}
