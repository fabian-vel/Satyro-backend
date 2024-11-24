package com.fabian_velasquez.satyro_backend.infrastructure.adapters.rest.controller;

import com.fabian_velasquez.satyro_backend.application.dto.request.EventRequest;
import com.fabian_velasquez.satyro_backend.application.dto.request.PaginatedEventRequest;
import com.fabian_velasquez.satyro_backend.application.dto.response.EventResponse;
import com.fabian_velasquez.satyro_backend.application.service.EventApplicationService;
import com.fabian_velasquez.satyro_backend.shared.message.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
public class EventController {

    private final EventApplicationService eventApplicationService;

    @PostMapping({"/getAll"})
    public ResponseEntity<ResponseMessage<EventResponse>> getAllEvent(@RequestBody PaginatedEventRequest paginatedEventRequest) {
        EventResponse result;
        result = eventApplicationService.getAllEvent(paginatedEventRequest);
        var message = new ResponseMessage<>(200, "getAll, process successful ", result);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage<String>> createEvent(@RequestBody EventRequest eventRequest) {
        eventApplicationService.createEvent(eventRequest);
        var message = new ResponseMessage<String>(200, "Event created successfully", null);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseMessage<String>> updateEvent(@RequestBody EventRequest eventRequest) {
        eventApplicationService.updateEvent(eventRequest);
        var message = new ResponseMessage<String>(200, "Event update successfully", null);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseMessage<String>> deleteEvent(@RequestBody EventRequest eventRequest) {
        eventApplicationService.deleteEvent(eventRequest);
        var message = new ResponseMessage<String>(200, "Event delete successfully", null);
        return ResponseEntity.ok(message);
    }


}
