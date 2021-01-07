package com.example.demo.service;

import com.example.demo.config.Interceptor;
import com.example.demo.dto.statistic.Statistics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;

@FeignClient(name = "onos-statistics", url = "http://192.168.56.1:8181/onos/v1", configuration = Interceptor.class)
public interface IStatisticService {
    @RequestMapping(method = RequestMethod.GET, value = "/statistics/delta/ports")
    Statistics getPortDeltaStatisticsForCalculation();
    @RequestMapping(method = RequestMethod.GET, value = "/statistics/delta/ports/{deviceId}")
    Statistics getPortDeltaStatistics(@PathVariable("deviceId") String deviceId);
    @RequestMapping(method = RequestMethod.GET, value = "/statistics/ports/{deviceId}")
    LinkedHashMap getPortStatistics(@PathVariable("deviceId") String deviceId);
    @RequestMapping(method = RequestMethod.GET, value = "/statistics/flows/tables/{deviceId}")
    LinkedHashMap getFlowTableStatistics(@PathVariable("deviceId") String deviceId);
}
