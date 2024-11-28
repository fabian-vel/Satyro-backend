package com.fabian_velasquez.satyro_backend.application.dto.request;

import lombok.Data;

@Data
public class DataMasterRequest {
    private String id;
    private String master;
    private String dataMasterName;
    private String code;
    private String description;
    private String state;
}
