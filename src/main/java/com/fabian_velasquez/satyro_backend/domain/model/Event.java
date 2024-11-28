package com.fabian_velasquez.satyro_backend.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Event {
    private String id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private int guestCapacity;
    private DataMaster category;
    private Date createdAt;
    private Date updatedAt;
}
