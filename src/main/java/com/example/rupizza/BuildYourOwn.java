package com.example.rupizza;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {
    public BuildYourOwn(Size size, Sauce sauce, ArrayList<Topping> toppings) {
        super(size, sauce);
        this.toppings = toppings;
    }
    @Override
    public double price() {
        return 0;
    }
}
