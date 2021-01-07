package com.example.demo.controller;


import com.example.demo.dto.host.Host;
import com.example.demo.service.IHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//Controller for Host.
@RestController
@RequestMapping("/hosts")
public class HostController {

    //Constructor injection.
    private final IHostService hostService;

    @Autowired
    public HostController(IHostService hostService
    ) {
        this.hostService = hostService;
    }

    //GET requests.
    @GetMapping("/{id}")
    public Host getHostById(@PathVariable("id") String id) {
        System.out.println(id);
        return hostService.getHostById(id);
    }

    @GetMapping("/{mac}/{vlan}")
    public Host getHostById(@PathVariable("mac") String mac, @PathVariable("vlan") String vlan) {
        return hostService.getHostByMacAndVlan(mac, vlan);
    }

    @GetMapping("")
    public ArrayList<Host> getHosts() {
        return (ArrayList) hostService.getHosts().get("hosts");
    }

    //DELETE requests.
    @DeleteMapping("/delete/{mac}/{vlan}")
    public String deleteHostByMacAndVlan(@PathVariable("mac") String mac, @PathVariable("vlan") String vlan) {
        return hostService.deleteHostByMacAndVlan(mac, vlan);
    }

    //POST requests.
    @PostMapping("/post")
    public String postHost(@RequestBody Host stream) {
        return hostService.postHost(stream);
    }
}



