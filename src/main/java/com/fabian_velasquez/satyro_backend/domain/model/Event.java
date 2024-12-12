package com.fabian_velasquez.satyro_backend.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
public class Event {
    private String id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalTime startTime;
    private LocalDateTime endDate;
    private LocalTime endTime;
    private String location;
    private int guestCapacity;
    private Category category;
    private Date createdAt;
    private Date updatedAt;
}
