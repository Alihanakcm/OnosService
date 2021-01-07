package com.example.demo.service;

import com.example.demo.config.Interceptor;
import com.example.demo.dto.application.Application;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.OctetStreamData;
import java.util.LinkedHashMap;

@FeignClient(name = "onos-application", url = "http://192.168.56.1:8181/onos/v1", configuration = Interceptor.class)
public interface IApplicationService {
    @RequestMapping(method = RequestMethod.GET, value = "/applications")
    LinkedHashMap getApplications();

    @RequestMapping(method = RequestMethod.DELETE, value = "/applications/{name}")
    void uninstallApplication(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.POST, value = "/applications")
    @Headers({"Content-Type: octet-stream", "Accept: text/plain"})
    void installApplication(@RequestParam("activate") boolean activate, @RequestBody byte[] stream);

    @RequestMapping(method = RequestMethod.GET, value = "/applications/{name}")
    Application getApplicationDetail(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.POST, value = "/applications/{name}/active")
    Application activateApplication(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.DELETE, value = "/applications/{name}/active")
    Application deactivateApplication(@PathVariable("name") String name);
}
