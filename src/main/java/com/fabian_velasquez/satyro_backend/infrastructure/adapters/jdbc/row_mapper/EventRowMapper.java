package com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc.row_mapper;

import com.fabian_velasquez.satyro_backend.application.dto.DataMasterDTO;
import com.fabian_velasquez.satyro_backend.application.dto.EventDTO;
import com.fabian_velasquez.satyro_backend.shared.utils.UtilDate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRowMapper implements RowMapper<EventDTO> {

    @Override
    public EventDTO mapRow(ResultSet rs, int i) throws SQLException {
        EventDTO dto = new EventDTO();
        dto.setId(rs.getString("A_id"));
        dto.setName(rs.getString("A_name"));
        dto.setDescription(rs.getString("A_description"));
        dto.setStartDate(UtilDate.convertToLocalDateTime(rs.getTimestamp("A_start_date")));
        dto.setStartTime(UtilDate.convertToLocalTime(rs.getTime("A_start_time")));
        dto.setEndDate(UtilDate.convertToLocalDateTime(rs.getTimestamp("A_end_date")));
        dto.setEndTime(UtilDate.convertToLocalTime(rs.getTime("A_end_time")));
        dto.setLocation(rs.getString("A_location"));
        dto.setGuestCapacity(rs.getInt("A_guest_capacity"));

        DataMasterDTO dataMaster = new DataMasterDTO();
        dataMaster.setId(rs.getString("B_id"));
        dataMaster.setMaster(rs.getString("B_master"));
        dataMaster.setDataMasterName(rs.getString("B_data_master"));
        dataMaster.setCode(rs.getString("B_code"));
        dto.setCategory(dataMaster);

        return dto;
    }

}
