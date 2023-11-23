package com.example.rupizza;

public class Deluxe extends Pizza {

    public Deluxe(Size size, Sauce sauce) {
        super(size, Sauce.TOMATO);
    }
    @Override
    public double price() {
        return 14.99;
    }
}
