package com.example.rupizza;
import java.util.ArrayList;

public abstract class Pizza {
    protected ArrayList<Topping> toppings; //Topping is a enum class
    protected Size size; //Size is a enum class
    protected Sauce sauce; //Sauce is a enum class
    protected boolean extraSauce;
    protected boolean extraCheese;

    public Pizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        this.size = size;
        this.sauce = sauce;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
    }
    public Pizza() {

    }

    public abstract void setPizzaSize(Size size);
    public abstract void setExtraSauce(boolean addSauce);

    public abstract void setExtraCheese(boolean addCheese);

    public abstract void setSauce(Sauce sauce);

    public abstract double price(); //polymorphism

    public abstract void setToppings(ArrayList<Topping> toppings);

    public abstract void setPrice(double amount);

    @Override
    public abstract String toString();


}
