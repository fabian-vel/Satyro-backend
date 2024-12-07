package com.fabian_velasquez.satyro_backend.shared.utils;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UtilDate {
    private static final ZoneId ZONE_ID_COLOMBIA = ZoneId.of("America/Bogota");
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Obtiene la fecha y hora actual en la zona horaria de Colombia.
     *
     * @return LocalDateTime con la fecha y hora actual.
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now(ZONE_ID_COLOMBIA);
    }

    /**
     * Obtiene la fecha y hora actual en la zona horaria de Colombia como un String formateado.
     *
     * @return Fecha y hora actual formateada como String.
     */
    public static String getCurrentTimestampString() {
        return getCurrentDateTime().format(TIMESTAMP_FORMATTER);
    }

    /**
     * Convierte un LocalDateTime a Date.
     *
     * @param localDateTime Fecha y hora a convertir.
     * @return Objeto Date equivalente.
     */
    public static Date convertToDate(LocalDateTime localDateTime) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZONE_ID_COLOMBIA);
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * Convierte un Date a LocalDateTime en la zona horaria de Colombia.
     *
     * @param date Objeto Date a convertir.
     * @return LocalDateTime equivalente.
     */
    public static LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant()
                .atZone(ZONE_ID_COLOMBIA)
                .toLocalDateTime();
    }

    /**
     * Formatea un LocalDateTime a un String en formato "yyyy-MM-dd HH:mm:ss".
     *
     * @param localDateTime Fecha y hora a formatear.
     * @return Fecha y hora formateada como String.
     */
    public static String formatDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(TIMESTAMP_FORMATTER);
    }

    /**
     * Obtiene la fecha y hora actual en formato Timestamp.
     *
     * @return Objeto Timestamp con la fecha y hora actual.
     */
    public static Timestamp getCurrentTimestamp() {
        LocalDateTime localDateTime = getCurrentDateTime();
        return Timestamp.valueOf(localDateTime);
    }

    /**
     * Convierte un Time a LocalTime en la zona horaria de Colombia.
     *
     * @param time Objeto Time a convertir.
     * @return LocalTime equivalente.
     */

    public static LocalTime convertToLocalTime(Time time) {
        return time.toLocalTime();
    }

}
