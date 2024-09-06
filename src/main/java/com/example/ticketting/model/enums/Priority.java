package com.example.ticketting.model.enums;

public enum Priority {

    LOW(0),
    MEDIUM(1),
    HIGH(2),
    URGENT(3);

    private final int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
