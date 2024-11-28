package com.fabian_velasquez.satyro_backend.infrastructure.adapters.rest.advice;

import com.fabian_velasquez.satyro_backend.shared.exception.EventException;
import com.fabian_velasquez.satyro_backend.shared.message.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(EventException.class)
    public ResponseEntity<Object> handleEmptyInput(EventException exception) {
        var message = new ResponseMessage<>(exception.getStatus().value(), exception.getMessage(), null);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage<Object>> handleGeneralException(Exception ex) {
        ResponseMessage<Object> response = new ResponseMessage<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
