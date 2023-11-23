package com.example.rupizza;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {
    public BuildYourOwn(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese, ArrayList<Topping> toppings) {
        super(size, sauce, extraSauce, extraCheese);
        this.toppings = toppings;
    }

    public void setExtraSauce() {
        extraSauce = true;
    }

    public void setExtraCheese() {
        extraCheese = true;
    }
    @Override
    public double price() {
        return 8.99 + size.getCode() + ((toppings.size() - 3) * 1.49);
    }
}
