package com.example.demo.dto.link;

import lombok.Data;

@Data
public class Link {
    SrcAndDst src;
    SrcAndDst dst;
    private String type;
    private String state;

    public SrcAndDst getSrc() {
        return src;
    }

    public void setSrc(SrcAndDst src) {
        this.src = src;
    }

    public SrcAndDst getDst() {
        return dst;
    }

    public void setDst(SrcAndDst dst) {
        this.dst = dst;
    }
}
