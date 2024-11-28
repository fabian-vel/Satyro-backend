package com.fabian_velasquez.satyro_backend.application.usecases;

import com.fabian_velasquez.satyro_backend.application.dto.DataMasterDTO;
import com.fabian_velasquez.satyro_backend.application.dto.request.DataMasterRequest;

import java.util.List;

public interface DataMasterService {
    List<DataMasterDTO> getAllDataMasterByMaster(DataMasterRequest dataMasterRequest);
}
