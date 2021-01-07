package com.example.demo.service;

import com.example.demo.config.Interceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;

@FeignClient(name = "onos-device", url = "http://192.168.56.1:8181/onos/v1", configuration = Interceptor.class)
public interface IDeviceService {
    @RequestMapping(method = RequestMethod.GET, value = "/devices")
    LinkedHashMap getDevices();

    @RequestMapping(method = RequestMethod.GET, value = "/devices/{deviceId}")
    LinkedHashMap getDeviceById(@PathVariable("deviceId") String deviceId);

    @RequestMapping(method = RequestMethod.GET, value = "/devices/{deviceId}/ports")
    LinkedHashMap getPortsByDeviceId(@PathVariable("deviceId") String deviceId);

    @RequestMapping(method = RequestMethod.GET, value = "/devices/ports")
    LinkedHashMap getPorts();

    @RequestMapping(method = RequestMethod.POST, value = "/devices/{id}/portstate/{portId}")
    void changePortState(@PathVariable("id") String id, @PathVariable String portId, @RequestBody Object stream);

    @RequestMapping(method = RequestMethod.DELETE, value = "/devices/{id}")
    void deleteDevice(@PathVariable("id") String id);

}
