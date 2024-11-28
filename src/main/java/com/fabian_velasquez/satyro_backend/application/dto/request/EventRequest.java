package com.fabian_velasquez.satyro_backend.application.dto.request;

import com.fabian_velasquez.satyro_backend.application.dto.DataMasterDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventRequest {
    private String id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private int guestCapacity;
    private DataMasterDTO category;
}
