package com.example.ticketting.model.enums;

public enum Status {

    OPEN(1),
    CLOSED(0),
    ESCALATED(2),
    REASSIGNE(3);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
