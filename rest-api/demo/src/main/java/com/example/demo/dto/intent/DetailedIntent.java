package com.example.demo.dto.intent;

import lombok.Data;

import java.util.List;

@Data
public class DetailedIntent {
    private String type;
    private String id;
    private String key;
    private String appId;
    private String[] resources;
    private String state;
    private IntentSelector selector;
    private IntentTreatment treatment;
    private int priority;
    private List<IntentConstraint> constraints;
    private String one;
    private String two;
}
