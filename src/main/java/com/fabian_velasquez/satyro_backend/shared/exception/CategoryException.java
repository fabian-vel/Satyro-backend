package com.fabian_velasquez.satyro_backend.shared.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CategoryException extends RuntimeException {

    private final HttpStatus status;
    private final String message;

    public CategoryException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public CategoryException(String message) {
        super(message);
        this.status = HttpStatus.NOT_FOUND;
        this.message = message;
    }

    public CategoryException() {
        super("An unexpected error occurred");
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = "An unexpected error occurred";
    }
}
