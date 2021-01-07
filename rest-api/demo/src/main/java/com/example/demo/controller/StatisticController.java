package com.example.demo.controller;

import com.example.demo.ddosDetection.Calculation;
import com.example.demo.dto.statistic.DeviceStatistic;
import com.example.demo.dto.statistic.PortStatistic;
import com.example.demo.dto.statistic.Statistics;
import com.example.demo.dto.statistic.TrafficData;
import com.example.demo.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/statistics")
public class StatisticController {
    private IStatisticService statisticService;

    @Autowired
    public StatisticController(IStatisticService statisticService) {
        this.statisticService = statisticService;
    }


    @GetMapping("/ddos")
    public TrafficData getPortData() throws InterruptedException {
        long packetSize = 0;
        long value = 0;
        PortStatistic portStatistic;
        Calculation calculation = new Calculation();

        ArrayList<DeviceStatistic> statistics = statisticService.getPortDeltaStatisticsForCalculation().getStatistics();
        int counter = 0;
        while (counter < 5) {
            for (int i = 0; i < statistics.size(); i++) {
                DeviceStatistic deviceStatistic = statistics.get(i);
                ArrayList<PortStatistic> portStatistics = statistics.get(0).getPorts();
                for (int j = 0; j < portStatistics.size(); j++) {
                    portStatistic = portStatistics.get(j);
                    value = portStatistic.getBytesReceived();
                    packetSize = value / 1048576;
                    System.out.println("PORT " + (j + 1) + ": " + packetSize);
                    if (packetSize > 0 && packetSize < 80) {
                        calculation.addGroup1(packetSize);
                    } else if (packetSize >= 80 && packetSize < 160) {
                        calculation.addGroup2(packetSize);
                    } else if (packetSize >= 160 && packetSize < 320) {
                        calculation.addGroup3(packetSize);
                    } else if (packetSize >= 320 && packetSize < 640) {
                        calculation.addGroup4(packetSize);
                    } else if (packetSize >= 640 && packetSize < 1280) {
                        calculation.addGroup5(packetSize);
                    } else if (packetSize >= 1280 && packetSize < 2560) {
                        calculation.addGroup6(packetSize);
                    } else if (packetSize > 2560) {
                        calculation.addGroup7(packetSize);
                    } else
                        continue;
                }

            }
            counter++;
            Thread.sleep(1000);
        }
        TrafficData trafficData = new TrafficData();
        double entropy = calculation.setParameters();
        trafficData.setEntropy(entropy);
        if (entropy < 3 && entropy != 0)
            trafficData.setDdos(true);
        else trafficData.setDdos(false);
        return trafficData;
    }

    @GetMapping("/delta/ports")
    public ArrayList<Statistics> getDeltaPortStatistics() {
        return (ArrayList) statisticService.getPortDeltaStatisticsForCalculation().getStatistics();
    }

    @GetMapping("/ports/{deviceId}")
    public ArrayList<Statistics> getPortStatistics(@PathVariable("deviceId") String deviceId) {
        return (ArrayList) statisticService.getPortStatistics(deviceId).get("statistics");
    }

    @GetMapping("/delta/ports/{deviceId}")
    public ArrayList getDeltaPortStatisticsForDeviceId(@PathVariable("deviceId") String deviceId) {
        return statisticService.getPortDeltaStatistics(deviceId).getStatistics();
    }

    @GetMapping("/flows/tables/{deviceId}")
    public ArrayList<Statistics> getFlowTableStatistics(@PathVariable("deviceId") String deviceId) {
        return (ArrayList) statisticService.getFlowTableStatistics(deviceId).get("statistics");
    }
}
