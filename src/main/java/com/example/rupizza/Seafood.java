package com.example.rupizza;

public class Seafood extends Pizza {
    public Seafood(Size size, Sauce sauce) {
        super(size, Sauce.ALFREDO);
    }
    @Override
    public double price() {
        return 17.99;
    }
}
