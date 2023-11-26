package com.example.rupizza;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {
    private double pizza_price;
    public BuildYourOwn(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese, ArrayList<Topping> toppings) {
        super(size, sauce, extraSauce, extraCheese);
        this.toppings = toppings;
    }

    public void setPizzaSize(Size size) {
        this.size = size;
    }
    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public void setExtraSauce(boolean addSauce) {
        extraSauce = addSauce;
    }

    public void setExtraCheese(boolean addCheese) {
        extraCheese = addCheese;
    }

    @Override
    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
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
    public void setPrice(double amount){
        pizza_price = amount;
    }

    @Override
    public double price() {
        return 8.99 + size.getCode();
    }

    public String toStringToppings(ArrayList <Topping> all_toppings){
        for (Topping allTopping : all_toppings) {
            return allTopping.toString() + ", ";
        }
        return "";
    }

    public String toString(){
        return "[Build Your Own] " + toStringToppings(toppings) + size.toString().toLowerCase() + ", " +
                sauce.toString().toLowerCase() + ", " + extrasToString() + " $" + pizza_price;
    }


}
