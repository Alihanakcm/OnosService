package com.example.demo.dto.intent;

import lombok.Data;

import java.util.List;

@Data
public class IntentTreatment {
    private List<IntentInstruction> instructions;
    private String[] deferred;
}
