package com.example.rupizza;

import java.util.ArrayList;

/**
 * Set-up for the Seafood Specialty Pizza.
 * @author Haejin Song, Deshna Doshi
 */
public class Seafood extends Pizza {
    /**
     * Constructor to create a Seafood Pizza.
     * @param size Size of the pizza.
     * @param sauce Sauce on the pizza.
     * @param extraSauce True if extra sauce is selected, false otherwise.
     * @param extraCheese True if extra cheese is selected, false otherwise.
     */
    public Seafood(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        super(size, Sauce.ALFREDO, extraSauce, extraCheese);
    }

    /**
     * Setter for the pizza size.
     * @param size Size of the pizza.
     */
    public void setPizzaSize(Size size) {
        this.size = size;
    }

    /**
     * Setter for the boolean extraSauce.
     * @param addSauce True if extra sauce is selected, false otherwise.
     */
    public void setExtraSauce(boolean addSauce) {
        extraSauce = addSauce;
    }

    /**
     * Setter for the boolean extraCheese.
     * @param addCheese True if extra cheese is selected, false otherwise.
     */
    public void setExtraCheese(boolean addCheese) {
        extraCheese = addCheese;
    }

    /**
     * Calculates the price of the pizza.
     * @return Price of the pizza based on the size.
     */
    @Override
    public double price() {
        double add = 0.0;
        if (extraCheese && extraSauce){
            add += 2.0;
        } else if (extraCheese){
            add += 1.0;
        } else if (extraSauce){
            add += 1.0;
        }
        return Double.parseDouble(String.format("%.2f", 17.99 + size.getCode() + add));
    }

    /**
     * Calculates the price based on the size of the pizza.
     * @return The price of the pizza.
     */
    public double advancedPrice() {
        return Double.parseDouble(String.format("%.2f", 17.99 + size.getCode()));
    }

    /**
     * Sets the sauce of the pizza.
     * @param sauce Sauce on the pizza.
     */
    public void setSauce(Sauce sauce) {
        this.sauce = Sauce.ALFREDO;
    }

    /**
     * Converts the pizza information into a String.
     * @return Pizza description.
     */
    public String toString(){
        return "[Seafood] Shrimp, Squid, CrabMeats, " + size.toString().toLowerCase() + ", " + sauce.toString().toLowerCase()
                + ", " + extrasToString() + " $" + price();
    }

    /**
     * toString() that transcribes the extra sauce and extra cheese parameters.
     * @return String of the extras chosen.
     */
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


    /**
     * Set the toppings of the pizza.
     * @param toppings ArrayList of the Toppings on the pizza.
     */
    @Override
    public void setToppings(ArrayList<Topping> toppings) {

    }

    /**
     * Setter for the price of the pizza.
     * @param amount The price of the pizza.
     */
    @Override
    public void setPrice (double amount){

    }
}

