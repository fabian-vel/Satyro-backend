package com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc;

import com.fabian_velasquez.satyro_backend.application.dto.request.EventRequest;
import com.fabian_velasquez.satyro_backend.application.dto.request.PaginatedEventRequest;
import com.fabian_velasquez.satyro_backend.infrastructure.adapters.mapper.EventMapper;
import com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc.row_mapper.EventRowMapper;
import com.fabian_velasquez.satyro_backend.domain.model.Event;
import com.fabian_velasquez.satyro_backend.domain.port.EventPort;
import com.fabian_velasquez.satyro_backend.shared.utils.SqlQueryUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EventJdbcAdapter implements EventPort {

    private final SqlQueryUtils sqlQueryUtils = SqlQueryUtils.getInstance();
    private final EventMapper eventMapper;

    JdbcTemplate jdbcTemplate;

    public EventJdbcAdapter(DataSource dataSource, EventMapper eventMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.eventMapper = eventMapper;
    }

    @Override
    public List<Event> getAll(PaginatedEventRequest paginatedEventRequest) {
        String sql = sqlQueryUtils.getQuery("Select_event_getAll");
        return eventMapper.toEventList( jdbcTemplate.query(sql, new EventRowMapper(),
                paginatedEventRequest.getSize(),
                paginatedEventRequest.getPage()));
    }

    @Override
    public Long getTotalEvent() {
        String sql = sqlQueryUtils.getQuery("Count_event_getAll");
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> rs.getLong("total"));
    }

    @Override
    public void save(Event event) {
        String sql = sqlQueryUtils.getQuery("Insert_event");
        jdbcTemplate.update(sql,
                event.getId(),
                event.getName(),
                event.getDescription(),
                event.getStartDate(),
                event.getEndDate(),
                event.getLocation(),
                event.getGuestCapacity(),
                event.getCategory(),
                event.getCreatedAt()
        );
    }

    @Override
    public void update(Event event) {
        String sql = sqlQueryUtils.getQuery("Update_event");
        jdbcTemplate.update(sql,
                event.getName(),
                event.getDescription(),
                event.getStartDate(),
                event.getEndDate(),
                event.getLocation(),
                event.getGuestCapacity(),
                event.getCategory(),
                event.getUpdatedAt(),
                event.getId()
        );
    }

    @Override
    public Event getById(EventRequest eventRequest) {
        String sql = sqlQueryUtils.getQuery("Select_event_byId");
        try {
            return eventMapper.toEvent( jdbcTemplate.queryForObject(sql, new EventRowMapper(),
                    eventRequest.getId()));
        }catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    @Override
    public void delete(EventRequest eventRequest) {
        String sql = sqlQueryUtils.getQuery("Delete_event");
        jdbcTemplate.update(sql, eventRequest.getId());
    }
}
