package com.example.demo.controller;

import com.example.demo.dto.link.Link;
import com.example.demo.dto.link.NewLink;
import com.example.demo.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/links")
public class LinksController {
    private final ILinkService linkService;

    @Autowired
    public LinksController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("")
    public ArrayList<Link> getLinks() {
        return (ArrayList<Link>) this.linkService.getLinks().get("links");
    }

}
