package com.example.rupizza;

public enum Sauce {
    TOMATO(0),
    ALFREDO(1);

    private final int CODE;

    Sauce(int code) {
        this.CODE = code;
    }

    public int getCode() {
        return CODE;
    }

}
