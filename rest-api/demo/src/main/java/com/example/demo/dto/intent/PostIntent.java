package com.example.demo.dto.intent;

import lombok.Data;

@Data
public class PostIntent {
    private String type;
    private String appId;
    private int priority;
    private String one;
    private String two;
}
