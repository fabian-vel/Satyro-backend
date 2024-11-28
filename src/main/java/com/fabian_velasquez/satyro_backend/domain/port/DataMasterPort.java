package com.fabian_velasquez.satyro_backend.domain.port;

import com.fabian_velasquez.satyro_backend.application.dto.request.DataMasterRequest;
import com.fabian_velasquez.satyro_backend.domain.model.DataMaster;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataMasterPort {
    List<DataMaster> getAllByMaster(DataMasterRequest dataMasterRequest);
}
