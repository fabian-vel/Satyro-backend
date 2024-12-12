package com.fabian_velasquez.satyro_backend.application.dto.request;

import com.fabian_velasquez.satyro_backend.application.dto.CategoryDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class EventRequest {
    private String id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalTime startTime;
    private LocalDateTime endDate;
    private LocalTime endTime;
    private String location;
    private int guestCapacity;
    private CategoryDTO category;
}
