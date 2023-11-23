package com.example.rupizza;

public class Supreme extends Pizza {
    public Supreme(Size size, Sauce sauce) {
        super(size, Sauce.TOMATO);
    }
    @Override
    public double price() {
        return 15.99;
    }
}
