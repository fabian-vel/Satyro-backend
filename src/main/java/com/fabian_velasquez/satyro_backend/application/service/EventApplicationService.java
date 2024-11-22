package com.fabian_velasquez.satyro_backend.application.service;

import com.fabian_velasquez.satyro_backend.application.dto.request.PaginatedEventRequest;
import com.fabian_velasquez.satyro_backend.application.dto.response.EventResponse;
import com.fabian_velasquez.satyro_backend.application.mapper.EventDTOMapper;
import com.fabian_velasquez.satyro_backend.domain.port.EventPort;
import com.fabian_velasquez.satyro_backend.application.dto.EventDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventApplicationService {

    private final EventPort eventPort;
    private final EventDTOMapper eventDTOMapper;

    public EventResponse getAllEvent(PaginatedEventRequest paginatedEventRequest) {
        EventResponse eventResponse = new EventResponse();
        List<EventDTO> eventList = eventDTOMapper.toEventDTOList(eventPort.getAll(paginatedEventRequest));
        Long total = eventPort.getTotalEvent();
        eventResponse.setEvents(eventList);
        eventResponse.setTotal(total);
        return eventResponse;
    }
}
