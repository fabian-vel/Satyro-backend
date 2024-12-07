package com.fabian_velasquez.satyro_backend.infrastructure.adapters.mapper;

import com.fabian_velasquez.satyro_backend.application.dto.DataMasterDTO;
import com.fabian_velasquez.satyro_backend.domain.model.DataMaster;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DataMasterAdapterMapper {
    List<DataMaster> toDataMasterList(List<DataMasterDTO> dataMasterDTOListList);
    DataMaster toDataMaster(DataMasterDTO dataMasterDTO);
}
