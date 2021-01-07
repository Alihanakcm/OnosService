package com.example.demo.dto.intent;


import lombok.Data;

import java.util.List;

@Data
public class IntentSelector {
    private List<IntentCriteria> criteria;
}
