package com.fabian_velasquez.satyro_backend.infrastructure.adapters.mapper;

import com.fabian_velasquez.satyro_backend.application.dto.EventDTO;
import com.fabian_velasquez.satyro_backend.domain.model.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventAdapterMapper {

    List<Event> toEventList(List<EventDTO> listEventDTO);
    Event toEvent(EventDTO eventDTO);
}
