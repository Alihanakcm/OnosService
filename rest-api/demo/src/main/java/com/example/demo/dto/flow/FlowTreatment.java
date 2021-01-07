package com.example.demo.dto.flow;

import lombok.Data;

import java.util.List;


@Data
public class FlowTreatment {
    private List<FlowInstruction> instructions;
    private Boolean clearDeferred;
    private String[] deferred;
}
