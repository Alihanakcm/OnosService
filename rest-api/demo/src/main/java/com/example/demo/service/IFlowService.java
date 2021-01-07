package com.example.demo.service;

import com.example.demo.config.Interceptor;
import com.example.demo.dto.flow.Flow;
import com.example.demo.dto.flow.FlowList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.LinkedHashMap;

//Service for Flow.
@FeignClient(name = "onos-flow", url = "http://192.168.56.1:8181/onos/v1", configuration = Interceptor.class)
public interface IFlowService {

    //GET requests.
    @GetMapping("/flows")
    LinkedHashMap getFlows();

    @GetMapping("/flows/table/{tableId}")
    LinkedHashMap getFlowsByTableId(@PathVariable("tableId") String tableId);

    @GetMapping("/flows/application/{appId}")
    LinkedHashMap getFlowsByAppId(@PathVariable("appId") String appId);

    @GetMapping("/flows/{deviceId}/{id}")
    LinkedHashMap getFlowsByDeviceIdAndFlowId(@PathVariable("deviceId") String deviceId, @PathVariable("id") long id);

    @GetMapping("/flows/{deviceId}")
    LinkedHashMap getFlowsByDeviceId(@PathVariable("deviceId") String deviceId);

    //POST requests.
    @PostMapping("/flows")
    String postFlow(@RequestParam("appId") String appId, @RequestBody Json stream);

    @PostMapping("/flows/{deviceId}")
    String postFlowByDeviceId(@PathVariable("deviceId") String deviceId, @RequestParam("appId") String appId, @RequestBody Flow stream);

    //DELETE requests.
    @DeleteMapping("/flows")
    String deleteFlow(@RequestBody FlowList stream);

    @DeleteMapping("/flows/application/{appId}")
    String deleteFlowByAppId(@PathVariable("appId") String appId);

    @DeleteMapping("/flows/{deviceId}/{id}")
    String deleteFlowByDeviceAndFlowId(@PathVariable("deviceId") String deviceId, @PathVariable("id") long id);
}

