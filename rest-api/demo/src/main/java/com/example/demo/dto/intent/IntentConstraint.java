package com.example.demo.dto.intent;

import lombok.Data;

@Data
public class IntentConstraint {
    private boolean inclusive;
    private String[] types;
    private String type;
}
