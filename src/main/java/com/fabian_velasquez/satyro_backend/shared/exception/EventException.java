package com.fabian_velasquez.satyro_backend.shared.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;



@Getter
public class EventException extends RuntimeException{

    private final HttpStatus status;
    private final String message;

    public EventException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public EventException(String message) {
        super(message);
        this.status = HttpStatus.NOT_FOUND;
        this.message = message;
    }

    public EventException() {
        super("An unexpected error occurred");
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = "An unexpected error occurred";
    }
}
