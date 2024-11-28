package com.fabian_velasquez.satyro_backend.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class DataMaster {

    private String id;
    private String master;
    private String dataMasterName;
    private String code;
    private String description;
    private String state;
    private Date createdAt;
    private Date updatedAt;
}
