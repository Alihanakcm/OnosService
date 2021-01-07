package com.example.demo.service;

import com.example.demo.config.Interceptor;
import com.example.demo.dto.intent.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

//Service for Intent.
@FeignClient(name = "onos-intent", url = "http://192.168.56.1:8181/onos/v1", configuration = Interceptor.class)
public interface IIntentService {

    //GET Requests.
    @GetMapping("/intents/{appId}/{key}")
    DetailedIntent getIntentByAppIdAndKey(@PathVariable("appId") String appId, @PathVariable("key") String key);

    @GetMapping("/intents")
    LinkedHashMap    getIntents();

    //DELETE requests.
    @DeleteMapping("intents/{appId}/{key}")
    String deleteIntentByAppIdAndKey(@PathVariable("appId") String appId, @PathVariable("key") String key);

    //POST requests.
    @PostMapping("/intents")
    String postIntent(@RequestBody PostIntent stream);
}

