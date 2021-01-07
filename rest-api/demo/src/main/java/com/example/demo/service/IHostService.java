package com.example.demo.service;


import com.example.demo.dto.host.Host;
import com.example.demo.config.Interceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

//Service for Host.
@FeignClient(name = "onos-host", url = "http://192.168.56.1:8181/onos/v1", configuration = Interceptor.class)
    public interface IHostService {
    //GET Requests.
    @GetMapping("/hosts/{id}")
    Host getHostById(@PathVariable("id") String id);

   @GetMapping("hosts/{mac}/{vlan}")
    Host getHostByMacAndVlan(@PathVariable("mac") String mac, @PathVariable("vlan") String vlan);

    @GetMapping("/hosts")
    LinkedHashMap getHosts();

    //DELETE requests.
    @DeleteMapping("hosts/{mac}/{vlan}")
    String deleteHostByMacAndVlan(@PathVariable("mac") String mac, @PathVariable("vlan") String vlan);

    //POST requests.
    @PostMapping("/hosts")
    String postHost(@RequestBody Host stream);
    }
