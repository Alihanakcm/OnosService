package com.example.demo.controller;


import com.example.demo.dto.flow.Flow;
import com.example.demo.dto.flow.FlowList;
import com.example.demo.service.IFlowService;
import com.fasterxml.jackson.core.JsonParser;
import org.apache.tomcat.util.json.JSONParser;
import org.bouncycastle.util.encoders.UTF8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.Convert;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;


//Controller for Flow.
@RestController
@RequestMapping("/flows")
public class FlowController {

    //Constructor injection.
    private final IFlowService flowService;

    @Autowired
    public FlowController(IFlowService flowService
    ) {
        this.flowService = flowService;
    }

    //GET requests.
    @GetMapping("")
    public ArrayList<Flow> getFlows() {
        return (ArrayList) flowService.getFlows().get("flows");
    }

//    @GetMapping("/table/{tableId}")
//    public ArrayList<Flow> getFlowsByTableId(@PathVariable("tableId") String tableId) {
//        return (ArrayList) flowService.getFlowsByTableId(tableId).get("flows");
//    }

//    @GetMapping("/application/{appId}")
//    public ArrayList<Flow> getFlowsByAppId(@PathVariable("appId") String appId) {
//        return (ArrayList) flowService.getFlowsByAppId(appId).get("flows");
//    }

    @GetMapping("/{deviceId}/{id}")
    public ArrayList<Flow> getFlowsByDeviceIdAndFlowId(@PathVariable("deviceId") String deviceId, @PathVariable("id") long id) {
        return (ArrayList) flowService.getFlowsByDeviceIdAndFlowId(deviceId, id).get("flows");
    }

    @GetMapping("/{deviceId}")
    public ArrayList<Flow> getFlowsByDeviceId(@PathVariable("deviceId") String deviceId) {
        return (ArrayList) flowService.getFlowsByDeviceId(deviceId).get("flows");
    }

    @PostMapping("")
    public String postFlow(@RequestParam("appId") String appId, @RequestBody String stream) {
        Json data= new Json((String) stream);
        return flowService.postFlow(appId, data);
    }

//    @PostMapping("/{deviceId}/{appId}")
//    public String postFlowByDeviceId(@PathVariable("deviceId") String deviceId, @PathVariable("appId") String appId, @RequestBody Flow stream) {
//        System.out.println("GELDI");
//        return flowService.postFlowByDeviceId(deviceId, appId, stream);
//    }

    //DELETE requests.
//    @DeleteMapping("")
//    public String deleteFlow(@RequestBody FlowList stream) {
//        return flowService.deleteFlow(stream);
//    }

//    @DeleteMapping("/application/{appId}")
//    public String deleteFlowByAppId(@PathVariable("appId") String appId) {
//        return flowService.deleteFlowByAppId(appId);
//    }

    @DeleteMapping("/{deviceId}/{id}")
    public String deleteFlowByDeviceAndFlowId(@PathVariable("deviceId") String deviceId, @PathVariable("id") long id) {
        return flowService.deleteFlowByDeviceAndFlowId(deviceId, id);
    }
}
