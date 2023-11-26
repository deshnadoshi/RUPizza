package com.example.rupizza;

import java.util.ArrayList;

public class Seafood extends Pizza {
    public Seafood(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, Sauce.ALFREDO, extraSauce, extraCheese);
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
        return 17.99 + size.getCode();
    }

    public void setSauce(Sauce sauce) {
        this.sauce = Sauce.ALFREDO;
    }

    public String toString(){
        return "";
    }

    @Override
    public void setToppings(ArrayList<Topping> toppings) {

    }
}

