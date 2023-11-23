package com.example.rupizza;

public class Pepperoni extends Pizza {
    public Pepperoni(Size size, Sauce sauce) {
        super(size, Sauce.TOMATO);
    }
    @Override
    public double price() {
        return 0;
    }
}
