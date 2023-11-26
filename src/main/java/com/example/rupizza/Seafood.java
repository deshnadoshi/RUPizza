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

    public double advancedPrice() {
        return 17.99 + size.getCode();
    }

    public void setSauce(Sauce sauce) {
        this.sauce = Sauce.ALFREDO;
    }

    public String toString(){
        return "[Seafood] Shrimp, Squid, CrabMeats, " + size.toString().toLowerCase() + ", " + sauce.toString().toLowerCase()
                + ", " + extrasToString() + " $" + price();
    }

    public String extrasToString(){
        if (extraCheese && extraSauce){
            return "extra sauce, extra cheese";
        } else if (extraCheese){
            return "extra cheese";
        } else if (extraSauce){
            return "extra sauce";
        }

        return "";
    }

    @Override
    public void setToppings(ArrayList<Topping> toppings) {

    }

    @Override
    public void setPrice (double amount){

    }
}

