package com.example.demo.dto.flow;

import lombok.Data;

import java.util.List;


@Data
public class FlowSelector {
    private List<FlowCriteria> criteria;
}
