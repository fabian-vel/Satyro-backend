package com.fabian_velasquez.satyro_backend.application.service;

import com.fabian_velasquez.satyro_backend.application.dto.DataMasterDTO;
import com.fabian_velasquez.satyro_backend.application.dto.request.DataMasterRequest;
import com.fabian_velasquez.satyro_backend.application.mapper.DataMasterDTOMapper;
import com.fabian_velasquez.satyro_backend.application.usecases.DataMasterService;
import com.fabian_velasquez.satyro_backend.domain.port.DataMasterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataMasterApplicationService implements DataMasterService {

    private final DataMasterPort dataMasterPort;
    private final DataMasterDTOMapper dataMasterDTOMapper;

    @Override
    public List<DataMasterDTO> getAllDataMasterByMaster(DataMasterRequest dataMasterRequest) {
        return dataMasterDTOMapper.toDataMasterDTOList(dataMasterPort.getAllByMaster(dataMasterRequest));
    }
}
