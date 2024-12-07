package com.fabian_velasquez.satyro_backend.application.usecases;

import com.fabian_velasquez.satyro_backend.application.dto.EventDTO;
import com.fabian_velasquez.satyro_backend.application.dto.request.EventRequest;
import com.fabian_velasquez.satyro_backend.application.dto.request.PaginatedEventRequest;
import com.fabian_velasquez.satyro_backend.application.dto.response.EventResponse;

public interface EventService {

    EventResponse getAllEvent(PaginatedEventRequest paginatedEventRequest);

    void createEvent(EventRequest eventRequest);

    void updateEvent(EventRequest eventRequest);

    void deleteEvent(EventRequest eventRequest);

    EventDTO getEventById(EventRequest eventRequest);
}
