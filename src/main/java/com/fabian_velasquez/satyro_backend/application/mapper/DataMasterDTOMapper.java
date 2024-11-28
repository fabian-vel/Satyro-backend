package com.fabian_velasquez.satyro_backend.application.mapper;

import com.fabian_velasquez.satyro_backend.application.dto.DataMasterDTO;
import com.fabian_velasquez.satyro_backend.domain.model.DataMaster;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DataMasterDTOMapper {

    List<DataMasterDTO> toDataMasterDTOList(List<DataMaster> dataMasterList);
    DataMasterDTO toDataMasterDTO(DataMaster dataMaster);
}
