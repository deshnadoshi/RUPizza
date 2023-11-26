package com.example.rupizza;

import java.util.ArrayList;

public class Deluxe extends Pizza {

    public Deluxe(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, Sauce.TOMATO, extraSauce, extraCheese);
    }

    public void setPizzaSize(Size size) {
        this.size = size;
    }
    public void setExtraSauce(boolean addSauce) {
        extraSauce = addSauce;
    }

    public void setExtraCheese(boolean addCheese) {
        extraCheese = addCheese;
    }
    @Override
    public double price() {
        return 14.99 + size.getCode();
    }

    @Override
    public void setToppings(ArrayList<Topping> toppings) {

    }

    public void setSauce(Sauce sauce) {
        this.sauce = Sauce.TOMATO;
    }

    public String toString(){
        return "[Deluxe] Sausage, Pepperoni, GreenPepper, Onion, Mushroom, ";
    }
}
