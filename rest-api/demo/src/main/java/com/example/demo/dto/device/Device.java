package com.example.demo.dto.device;

import lombok.Data;

@Data
public class Device {
    String id;
    String type;
    Boolean available;
    String role;
    String mfr;
    String hw;
    String sw;
    String serial;
    String driver;
    String chassisId;
    String lastUpdate;
    String humanReadableLastUpdate;
    Object annotations;
}
