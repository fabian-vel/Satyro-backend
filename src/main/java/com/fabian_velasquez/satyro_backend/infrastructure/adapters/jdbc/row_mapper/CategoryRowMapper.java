package com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc.row_mapper;

import com.fabian_velasquez.satyro_backend.application.dto.CategoryDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<CategoryDTO> {
    @Override
    public CategoryDTO mapRow(ResultSet rs, int i) throws SQLException {
        CategoryDTO dto = new CategoryDTO();

        dto.setId(rs.getString("A_id"));
        dto.setName(rs.getString("A_name"));
        dto.setDescription(rs.getString("A_description"));
        dto.setState(rs.getString("A_state"));

        return dto;
    }
}
