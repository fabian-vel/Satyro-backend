package com.fabian_velasquez.satyro_backend.application.dto.response;

import com.fabian_velasquez.satyro_backend.application.dto.EventDTO;
import lombok.Data;

import java.util.List;

@Data
public class EventResponse {

    private List<EventDTO> events;
    private Long total;
}
