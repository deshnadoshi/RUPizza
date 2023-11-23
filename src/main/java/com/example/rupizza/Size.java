package com.example.rupizza;

public enum Size {
    SMALL(0),
    MEDIUM(1),
    LARGE(2);

    private final int CODE;

    Size(int code) {
        this.CODE = code;
    }

    public int getCode() {
        return CODE;
    }
}
