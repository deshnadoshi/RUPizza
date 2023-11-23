package com.example.rupizza;

public class Seafood extends Pizza {
    public Seafood(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, Sauce.ALFREDO, extraSauce, extraCheese);
    }

    public void setExtraSauce() {
        extraSauce = true;
    }

    public void setExtraCheese() {
        extraCheese = true;
    }
    @Override
    public double price() {
        return 17.99 + size.getCode();
    }
}
