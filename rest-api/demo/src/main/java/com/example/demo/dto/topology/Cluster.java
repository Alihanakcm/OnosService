package com.example.demo.dto.topology;


import lombok.Data;

@Data
public class Cluster {
    private long id;
    private long deviceCount;
    private long linkCount;
    private String root;
}
