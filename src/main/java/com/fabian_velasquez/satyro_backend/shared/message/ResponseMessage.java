package com.fabian_velasquez.satyro_backend.shared.message;

import lombok.Data;

@Data
public class ResponseMessage<T> {
    private int code;
    private String message;
    private T data;

    public ResponseMessage() {
    }

    public ResponseMessage(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
