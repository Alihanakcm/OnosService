package com.example.demo.controller;

import com.example.demo.dto.device.Device;
import com.example.demo.dto.device.Port;
import com.example.demo.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/devices")
public class DeviceController {

    private IDeviceService deviceService;

    @Autowired
    public DeviceController(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("")
    public ArrayList<Device> getDevices() {
        return (ArrayList) deviceService.getDevices().get("devices");

    }

    @GetMapping("/{deviceId}")
    public Object getDeviceById(@PathVariable("deviceId") String deviceId) {
        return deviceService.getDeviceById(deviceId);
    }

    @GetMapping("/{deviceId}/ports")
    public ArrayList<Port> getPortsByDeviceId(@PathVariable("deviceId") String deviceId) {
        return (ArrayList) deviceService.getPortsByDeviceId(deviceId).get("ports");
    }

    @GetMapping("/ports")
    public ArrayList<Port> getPorts() {
        return (ArrayList) deviceService.getPorts().get("ports");
    }

    @PostMapping("")
    public void changePortState(@RequestParam("id") String id, @RequestParam("portId") String portId, @RequestBody Object stream) {
        deviceService.changePortState(id, portId, stream);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable("id") String id)
    {
        System.out.println("GEldi");
        deviceService.deleteDevice(id);
    }

}
