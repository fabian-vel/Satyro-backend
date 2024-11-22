package com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc.row_mapper;

import com.fabian_velasquez.satyro_backend.application.dto.EventDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRowMapper implements RowMapper<EventDTO> {

    @Override
    public EventDTO mapRow(ResultSet rs, int i) throws SQLException {
        EventDTO event = new EventDTO();
        event.setId(rs.getString("id"));
        event.setName(rs.getString("name"));
        event.setDescription(rs.getString("description"));
        event.setStartDate(rs.getDate("start_date"));
        event.setEndDate(rs.getDate("end_date"));
        event.setLocation(rs.getString("location"));
        event.setGuestCapacity(rs.getInt("guest_capacity"));
        event.setCategory(rs.getString("category"));
        return event;
    }

}
