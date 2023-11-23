package com.example.rupizza;

public class Meatzza extends Pizza {

    public Meatzza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, Sauce.TOMATO, extraSauce, extraCheese);
    }

    public void setExtraSauce() {
        extraSauce = true;
    }

    public void setExtraCheese() {
        extraCheese = true;
    }
    @Override
    public double price() {
        return 16.99 + size.getCode();
    }
}
