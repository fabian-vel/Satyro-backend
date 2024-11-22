package com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc;

import com.fabian_velasquez.satyro_backend.application.dto.request.PaginatedEventRequest;
import com.fabian_velasquez.satyro_backend.infrastructure.adapters.mapper.EventMapper;
import com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc.row_mapper.EventRowMapper;
import com.fabian_velasquez.satyro_backend.domain.model.Event;
import com.fabian_velasquez.satyro_backend.domain.port.EventPort;
import com.fabian_velasquez.satyro_backend.shared.utils.SqlQueryUtils;
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
}
