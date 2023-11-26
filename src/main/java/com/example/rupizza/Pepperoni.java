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

    public double advancedPrice() {
        return 10.99 + size.getCode();
    }

    public void setSauce(Sauce sauce) {
        this.sauce = Sauce.TOMATO;
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

    public String toString(){
        return "[Pepperoni] Pepperoni, " + size.toString().toLowerCase() + ", " + sauce.toString().toLowerCase()
                + ", " + extrasToString() + " $" + price();
    }

    @Override
    public void setToppings(ArrayList<Topping> toppings) {

    }
    @Override
    public void setPrice (double amount){

    }
}
