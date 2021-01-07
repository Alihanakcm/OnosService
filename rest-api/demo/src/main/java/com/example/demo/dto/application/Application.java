package com.example.demo.dto.application;

import lombok.Data;

@Data
public class Application {
    String name;
    int id;
    String version;
    String category;
    String description;
    String readme;
    String origin;
    String url;
    String featuresRepo;
    String state;
    String[] features;
    String[] permissions;
    String[] requiredApps;
}
