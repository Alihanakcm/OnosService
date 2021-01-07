package com.example.demo.dto.topology;

import lombok.Data;

@Data
public class Topology {
    private long time;
    private int devices;
    private int links;
    private int clusters;

}
