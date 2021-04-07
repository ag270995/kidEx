package com.assignment.core.enums;

public enum Status {
    SUCCESS(0, "Success"),
    FAILURE(1, "Failure");

    private final String value;
    private final int type;

    Status(final int type, final String value) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }
    public int getType() {
        return type;
    }
}
