package com.fabian_velasquez.satyro_backend.application.mapper;

import com.fabian_velasquez.satyro_backend.application.dto.EventDTO;
import com.fabian_velasquez.satyro_backend.application.dto.request.EventRequest;
import com.fabian_velasquez.satyro_backend.domain.model.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventApplicationMapper {

    List<EventDTO> toEventDTOList(List<Event> listEvent);
    EventDTO toEventDTO(Event event);

    Event toEvent(EventRequest eventRequest);
}
