package com.example.rupizza;

public class Deluxe extends Pizza {

    public Deluxe(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, Sauce.TOMATO, extraSauce, extraCheese);
    }

    public void setPizzaSize(Size size) {
        this.size = size;
    }
    public void setExtraSauce() {
        extraSauce = true;
    }

    public void setExtraCheese() {
        extraCheese = true;
    }
    @Override
    public double price() {
        return 14.99 + size.getCode();
    }

    public void setSauce(Sauce sauce) {
        this.sauce = Sauce.TOMATO;
    }
}
