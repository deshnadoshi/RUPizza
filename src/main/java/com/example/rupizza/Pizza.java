package com.example.rupizza;
import java.util.ArrayList;

public abstract class Pizza {
    protected ArrayList<Topping> toppings; //Topping is a enum class
    protected Size size; //Size is a enum class
    protected Sauce sauce; //Sauce is a enum class
    protected boolean extraSauce;
    protected boolean extraCheese;

    public Pizza(Size size, Sauce sauce) {
        this.size = size;
        this.sauce = sauce;
    }
    public Pizza() {

    }

    public abstract double price(); //polymorphism
}
