package com.fabian_velasquez.satyro_backend.application.service;

import com.fabian_velasquez.satyro_backend.application.dto.request.EventRequest;
import com.fabian_velasquez.satyro_backend.application.dto.request.PaginatedEventRequest;
import com.fabian_velasquez.satyro_backend.application.dto.response.EventResponse;
import com.fabian_velasquez.satyro_backend.application.mapper.EventApplicationMapper;
import com.fabian_velasquez.satyro_backend.application.usecases.EventService;
import com.fabian_velasquez.satyro_backend.domain.model.Event;
import com.fabian_velasquez.satyro_backend.domain.port.EventPort;
import com.fabian_velasquez.satyro_backend.application.dto.EventDTO;

import com.fabian_velasquez.satyro_backend.shared.exception.EventException;
import com.fabian_velasquez.satyro_backend.shared.utils.UUIDGenerator;
import com.fabian_velasquez.satyro_backend.shared.utils.UtilDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventApplicationService implements EventService {

    private final EventPort eventPort;
    private final EventApplicationMapper eventApplicationMapper;

    private static final String NON_EXISTENT_EVENT = "El evento no existe";

    @Override
    public EventResponse getAllEvent(PaginatedEventRequest paginatedEventRequest) {
        EventResponse eventResponse = new EventResponse();
        List<EventDTO> eventList = eventApplicationMapper.toEventDTOList(eventPort.getAll(paginatedEventRequest));
        Long total = eventPort.getTotalEvent();
        eventResponse.setEvents(eventList);
        eventResponse.setTotal(total);
        return eventResponse;
    }

    @Override
    public void createEvent(EventRequest eventRequest) {
        Event event = eventApplicationMapper.toEvent(eventRequest);

        event.setId(UUIDGenerator.generateUUID());
        event.setCreatedAt(UtilDate.getCurrentTimestamp());

        eventPort.save(event);
    }

    @Override
    public void updateEvent(EventRequest eventRequest) {
        Event existingEvent = eventPort.getById(eventRequest);

        if(existingEvent != null) {
            Event event = eventApplicationMapper.toEvent(eventRequest);
            event.setUpdatedAt(UtilDate.getCurrentTimestamp());

            eventPort.update(event);
        } else {
            throw new EventException(NON_EXISTENT_EVENT);
        }
    }

    @Override
    public void deleteEvent(EventRequest eventRequest) {
        Event existingEvent = eventPort.getById(eventRequest);

        if(existingEvent != null) {
            eventPort.delete(eventRequest);
        } else {
            throw new EventException(NON_EXISTENT_EVENT);
        }
    }

    @Override
    public EventDTO getEventById(EventRequest eventRequest) {
        Event event = eventPort.getById(eventRequest);

        if(event != null) {
            return eventApplicationMapper.toEventDTO(event);
        } else {
            throw new EventException(NON_EXISTENT_EVENT);
        }
    }
}
