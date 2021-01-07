package com.example.demo.dto.statistic;

import lombok.Data;

import java.util.ArrayList;

@Data
public class DeviceStatistic {
    String device;
    ArrayList<PortStatistic> ports;
}
