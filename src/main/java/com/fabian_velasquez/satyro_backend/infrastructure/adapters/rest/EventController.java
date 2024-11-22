package com.fabian_velasquez.satyro_backend.infrastructure.adapters.rest;

import com.fabian_velasquez.satyro_backend.application.dto.request.PaginatedEventRequest;
import com.fabian_velasquez.satyro_backend.application.dto.response.EventResponse;
import com.fabian_velasquez.satyro_backend.application.service.EventApplicationService;
import com.fabian_velasquez.satyro_backend.shared.message.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final EventApplicationService eventApplicationService;


    public EventController(EventApplicationService eventApplicationService) {
        this.eventApplicationService = eventApplicationService;
    }

    @PostMapping({"/getAll"})
    public ResponseEntity<ResponseMessage<EventResponse>> getAllEvent(@RequestBody PaginatedEventRequest paginatedEventRequest) {
        EventResponse result;
        result = eventApplicationService.getAllEvent(paginatedEventRequest);
        var message = new ResponseMessage<>(200, "getAll, process successful ", result);
        return ResponseEntity.ok(message);
    }


}
