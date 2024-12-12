package com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc;

import com.fabian_velasquez.satyro_backend.application.dto.request.EventRequest;
import com.fabian_velasquez.satyro_backend.application.dto.request.PaginatedEventRequest;
import com.fabian_velasquez.satyro_backend.infrastructure.adapters.mapper.EventAdapterMapper;
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
    private final EventAdapterMapper eventAdapterMapper;

    JdbcTemplate jdbcTemplate;

    public EventJdbcAdapter(DataSource dataSource, EventAdapterMapper eventAdapterMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.eventAdapterMapper = eventAdapterMapper;
    }

    @Override
    public List<Event> getAll(PaginatedEventRequest paginatedEventRequest) {
        String sql = sqlQueryUtils.getQuery("Select_event_getAll");

        var limit = paginatedEventRequest.getSize();
        var offset = paginatedEventRequest.getPage() * paginatedEventRequest.getSize();

        return eventAdapterMapper.toEventList( jdbcTemplate.query(sql, new EventRowMapper(),
                limit, offset));
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
                event.getStartTime(),
                event.getEndDate(),
                event.getEndTime(),
                event.getLocation(),
                event.getGuestCapacity(),
                event.getCategory().getId(),
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
                event.getStartTime(),
                event.getEndDate(),
                event.getEndTime(),
                event.getLocation(),
                event.getGuestCapacity(),
                event.getCategory().getId(),
                event.getUpdatedAt(),
                event.getId()
        );
    }

    @Override
    public Event getById(EventRequest eventRequest) {
        String sql = sqlQueryUtils.getQuery("Select_event_byId");
        try {
            return eventAdapterMapper.toEvent(
                    jdbcTemplate.queryForObject(sql, new EventRowMapper(),
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
