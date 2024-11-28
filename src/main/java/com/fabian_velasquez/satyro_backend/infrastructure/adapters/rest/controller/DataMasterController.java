package com.fabian_velasquez.satyro_backend.infrastructure.adapters.rest.controller;

import com.fabian_velasquez.satyro_backend.application.dto.DataMasterDTO;
import com.fabian_velasquez.satyro_backend.application.dto.request.DataMasterRequest;
import com.fabian_velasquez.satyro_backend.application.usecases.DataMasterService;
import com.fabian_velasquez.satyro_backend.shared.message.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dataMaster")
@RequiredArgsConstructor
public class DataMasterController {

    private final DataMasterService dataMasterService;

    @PostMapping("/getAllByMaster")
    public ResponseEntity<ResponseMessage<List<DataMasterDTO>>> getAllDataMasterByMaster(@RequestBody DataMasterRequest dataMasterRequest) {
        List<DataMasterDTO> result;
        result = dataMasterService.getAllDataMasterByMaster(dataMasterRequest);
        var message = new ResponseMessage<>(200, "getAllByMaster, process successful ", result);
        return ResponseEntity.ok(message);
    }
}
