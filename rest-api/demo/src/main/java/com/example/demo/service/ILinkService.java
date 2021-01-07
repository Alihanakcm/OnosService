package com.example.demo.service;

import com.example.demo.config.Interceptor;
import com.example.demo.dto.link.Link;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@FeignClient(name = "onos-links", url = "http://192.168.56.1:8181/onos/v1", configuration = Interceptor.class)
public interface ILinkService {

    @GetMapping("/links")
    LinkedHashMap getLinks();
}
