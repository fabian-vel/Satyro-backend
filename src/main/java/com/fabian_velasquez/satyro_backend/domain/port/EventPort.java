package com.fabian_velasquez.satyro_backend.domain.port;

import com.fabian_velasquez.satyro_backend.application.dto.request.EventRequest;
import com.fabian_velasquez.satyro_backend.application.dto.request.PaginatedEventRequest;
import com.fabian_velasquez.satyro_backend.domain.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventPort {

    List<Event> getAll(PaginatedEventRequest paginatedEventRequest);

    Long getTotalEvent();

    void save(Event event);

    void update(Event event);

    Event getById(EventRequest eventRequest);

    void delete(EventRequest eventRequest);
}
