package com.fabian_velasquez.satyro_backend.application.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EventDTO {
    private String id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String location;
    private int guestCapacity;
    private String category;
}
