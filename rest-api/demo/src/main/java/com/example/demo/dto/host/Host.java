package com.example.demo.dto.host;

import lombok.Data;

import java.util.List;

@Data
public class Host {

    private String id;
    private String mac;
    private String vlan;
    private String innerVlan;
    private String outerTpid;
    private Boolean configured;
    private Boolean suspended;
    private String[] ipAddresses;
    private List<Location> locations;

}