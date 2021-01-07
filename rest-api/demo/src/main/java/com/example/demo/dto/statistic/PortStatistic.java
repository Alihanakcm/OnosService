package com.example.demo.dto.statistic;

import lombok.Data;

@Data
public class PortStatistic {
    int port;
    long packetsReceived;
    long packetsSent;
    long bytesReceived;
    long bytesSent;
    long packetsRxDropped;
    long packetsTxDropped;
    long packetsRxErrors;
    long packetsTxErrors;
    long durationSec;

}
