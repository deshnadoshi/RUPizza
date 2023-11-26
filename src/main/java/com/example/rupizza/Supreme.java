package com.example.rupizza;

import java.util.ArrayList;

public class Supreme extends Pizza {
    public Supreme(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
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
        return 15.99 + size.getCode();
    }

    public void setSauce(Sauce sauce) {
        this.sauce = Sauce.TOMATO;
    }

    @Override
    public String toString(){
        return "[Supreme] Sausage, Pepperoni, Ham, GreenPepper, Onion, BlackOlives, Mushroom, " + size.toString().toLowerCase()
                + ", " + sauce.toString().toLowerCase() + ", " + extrasToString() + " $" + price();
    }

    @Override
    public void setToppings(ArrayList<Topping> toppings) {

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
    public void setPrice (double amount){

    }
}
