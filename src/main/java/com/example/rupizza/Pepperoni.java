package com.example.rupizza;

import java.util.ArrayList;

public class Pepperoni extends Pizza {
    public Pepperoni(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
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
        return 10.99 + size.getCode();
    }

    public void setSauce(Sauce sauce) {
        this.sauce = Sauce.TOMATO;
    }

    public String toString(){
        return "";
    }

    @Override
    public void setToppings(ArrayList<Topping> toppings) {

    }
    @Override
    public void setPrice (double amount){

    }
}
