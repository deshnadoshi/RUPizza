package com.example.rupizza;

import static org.junit.Assert.*;
public class BuildYourOwnTest {

    @org.junit.Test
    public void test_NoToppings() {
        Pizza testPizza = PizzaMaker.createPizza("BuildYourOwn");
        testPizza.setPizzaSize(Size.SMALL);
        testPizza.setSauce(Sauce.TOMATO);
        testPizza.setExtraSauce(false);
        testPizza.setExtraCheese(false);



    }
}