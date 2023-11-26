package com.example.rupizza;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {
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
    @Override
    public double price() {
        return 8.99 + size.getCode();
    }

    public String toStringToppings(ArrayList <Topping> all_toppings){
        for (int i = 0; i < all_toppings.size(); i++){
            return all_toppings.get(i).toString() + ", ";
        }
        return "";
    }

    public String toString(){
        return "[Build Your Own] " + toStringToppings(toppings);
    }


}
