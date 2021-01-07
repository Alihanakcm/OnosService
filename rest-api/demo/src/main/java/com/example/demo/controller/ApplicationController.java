package com.example.demo.controller;

import com.example.demo.dto.application.Application;
import com.example.demo.service.IApplicationService;
import feign.Headers;
import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.OctetStreamData;
import java.util.ArrayList;


@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private IApplicationService applicationService;

    @Autowired
    ApplicationController(IApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("")
    public ArrayList<Application> getApplications() {
        return (ArrayList) applicationService.getApplications().get("applications");
    }

    @DeleteMapping("/{name}")
    public void uninstallApplication(@PathVariable("name") String name) {
        this.applicationService.uninstallApplication(name);
    }

    @PostMapping(value = "")
    @Headers({"Content-Type: octet-stream", "Accept: text/plain"})
    public void installApplication(@RequestParam("activate") boolean activate, @RequestBody byte[] stream) {
        this.applicationService.installApplication(activate, stream);
    }

    @PostMapping(value = "/{name}/active")
    public void activateApplication(@PathVariable("name") String name) {
        System.out.println("SUCCESS");
        this.applicationService.activateApplication(name);
    }

    @DeleteMapping(value = "/{name}/active")
    public void deactivateApplication(@PathVariable("name") String name) {
        System.out.println("SUCCESS- DELETE");
        this.applicationService.deactivateApplication(name);
    }

    @GetMapping("/{name}")
    public Application getApplicationDetail(@PathVariable("name") String name) {
        return this.applicationService.getApplicationDetail(name);
    }

}
