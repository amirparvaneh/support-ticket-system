package com.example.ticketting.model.enums;

public enum SenderType {
    CUSTOMER(-1),
    AGENT(1);

    private final int value;

    SenderType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
