package com.example.demo.dto.flow;

import lombok.Data;


@Data
public class Flow {
    private int groupId;
    private String state;
    private long life;
    private String liveType;
    private long lastSeen;
    private long packets;
    private long bytes;
    private long id;
    private String appId;
    private long priority;
    private long timeout;
    private Boolean isPermanent;
    private String deviceId;
    private int tableId;
    private String tableName;
    private FlowTreatment treatment;
    private FlowSelector selector;

}
