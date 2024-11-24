package com.fabian_velasquez.satyro_backend.application.mapper;

import com.fabian_velasquez.satyro_backend.application.dto.request.EventRequest;
import com.fabian_velasquez.satyro_backend.domain.model.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventRequestMapper {
    Event toEvent(EventRequest eventRequest);
}
