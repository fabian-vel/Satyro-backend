package com.fabian_velasquez.satyro_backend.shared.utils;

import java.util.UUID;

public class UUIDGenerator {
    /**
     * Genera un UUID aleatorio.
     *
     * @return un UUID en formato String.
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
