package com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc.row_mapper;

import com.fabian_velasquez.satyro_backend.application.dto.DataMasterDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataMasterRowMapper implements RowMapper<DataMasterDTO> {
    @Override
    public DataMasterDTO mapRow(ResultSet rs, int i) throws SQLException {
        DataMasterDTO dataMasterDTO = new DataMasterDTO();

        dataMasterDTO.setId(rs.getString("id"));
        dataMasterDTO.setMaster(rs.getString("master"));
        dataMasterDTO.setDataMasterName(rs.getString("data_master"));
        dataMasterDTO.setCode(rs.getString("code"));
        dataMasterDTO.setDescription(rs.getString("description"));
        dataMasterDTO.setState(rs.getString("state"));

        return dataMasterDTO;
    }
}
