package com.example.demo.dto.intent;

import lombok.Data;

@Data
public class Intent {
    private String type;
    private String id;
    private String key;
    private String appId;
    private String[] resources;
    private String state;

}
