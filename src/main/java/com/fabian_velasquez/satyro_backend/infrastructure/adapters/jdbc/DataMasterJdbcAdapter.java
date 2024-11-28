package com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc;

import com.fabian_velasquez.satyro_backend.application.dto.request.DataMasterRequest;
import com.fabian_velasquez.satyro_backend.domain.model.DataMaster;
import com.fabian_velasquez.satyro_backend.domain.port.DataMasterPort;
import com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc.row_mapper.DataMasterRowMapper;
import com.fabian_velasquez.satyro_backend.infrastructure.adapters.mapper.DataMasterMapper;
import com.fabian_velasquez.satyro_backend.shared.utils.SqlQueryUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DataMasterJdbcAdapter implements DataMasterPort {

    private final SqlQueryUtils sqlQueryUtils = SqlQueryUtils.getInstance();
    private final DataMasterMapper dataMasterMapper;

    JdbcTemplate jdbcTemplate;

    public DataMasterJdbcAdapter(DataSource dataSource, DataMasterMapper dataMasterMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataMasterMapper = dataMasterMapper;
    }

    @Override
    public List<DataMaster> getAllByMaster(DataMasterRequest dataMasterRequest) {
        String sql = sqlQueryUtils.getQuery("Select_dataMaster_byMaster");
        return dataMasterMapper.toDataMasterList(jdbcTemplate.query(sql, new DataMasterRowMapper(),
                dataMasterRequest.getMaster()));
    }
}
