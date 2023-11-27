package com.example.rupizza;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * JUnit test for Pizza.price()
 * @author Deshna Doshi, Haejin Song
 */

public class BuildYourOwnTest {

    /**
     * Test the price of a small pizza with no extra sauce or cheese selected.
     */
    @org.junit.Test
    public void test_NoExtras() {
        Pizza testPizza = PizzaMaker.createPizza("BuildYourOwn");
        if (testPizza != null){
            testPizza.setPizzaSize(Size.SMALL);
            testPizza.setSauce(Sauce.TOMATO);

            ArrayList <Topping> add_toppings = new ArrayList<>();
            add_toppings.add(Topping.PINEAPPLE);
            add_toppings.add(Topping.SQUID);
            add_toppings.add(Topping.CRABMEATS);

            testPizza.setToppings(add_toppings);
            testPizza.setExtraSauce(false);
            testPizza.setExtraCheese(false);
        }

        assertEquals(8.99, testPizza.price(), 0);

    }

    /**
     * Test the price of a medium pizza with three toppings.
     */
    @org.junit.Test
    public void test_ThreeToppings() {
        Pizza testPizza = PizzaMaker.createPizza("BuildYourOwn");
        if (testPizza != null){
            testPizza.setPizzaSize(Size.MEDIUM);
            testPizza.setSauce(Sauce.TOMATO);
            testPizza.setExtraSauce(false);
            testPizza.setExtraCheese(false);

            ArrayList <Topping> add_toppings = new ArrayList<>();
            add_toppings.add(Topping.HAM);
            add_toppings.add(Topping.BEEF);
            add_toppings.add(Topping.SAUSAGE);
            testPizza.setToppings(add_toppings);
        }

        assertEquals(10.99, testPizza.price(), 0);

    }

    /**
     * Test the price of a large pizza with more than 3 toppings (5 toppings).
     */
    @org.junit.Test
    public void test_OverThreeToppings() {
        Pizza testPizza = PizzaMaker.createPizza("BuildYourOwn");
        if (testPizza != null){
            testPizza.setPizzaSize(Size.LARGE);
            testPizza.setSauce(Sauce.ALFREDO);
            testPizza.setExtraSauce(false);
            testPizza.setExtraCheese(false);

            ArrayList <Topping> add_toppings = new ArrayList<>();
            add_toppings.add(Topping.HAM);
            add_toppings.add(Topping.BEEF);
            add_toppings.add(Topping.SAUSAGE);
            add_toppings.add(Topping.ONION);
            add_toppings.add(Topping.SHRIMP);
            testPizza.setToppings(add_toppings);
        }

        assertEquals(15.97, testPizza.price(), 0);

    }

    /**
     * Test the price of a large pizza with extra cheese.
     */
    @org.junit.Test
    public void test_ExtraCheese() {
        Pizza testPizza = PizzaMaker.createPizza("BuildYourOwn");
        if (testPizza != null){
            testPizza.setPizzaSize(Size.LARGE);
            testPizza.setSauce(Sauce.TOMATO);
            testPizza.setExtraSauce(false);
            testPizza.setExtraCheese(true);

            ArrayList <Topping> add_toppings = new ArrayList<>();
            add_toppings.add(Topping.HAM);
            add_toppings.add(Topping.BEEF);
            add_toppings.add(Topping.SAUSAGE);
            testPizza.setToppings(add_toppings);
        }

        assertEquals(13.99, testPizza.price(), 0);

    }

    /**
     * Test the price of a medium pizza with extra sauce.
     */
    @org.junit.Test
    public void test_ExtraSauce() {
        Pizza testPizza = PizzaMaker.createPizza("BuildYourOwn");
        if (testPizza != null){
            testPizza.setPizzaSize(Size.MEDIUM);
            testPizza.setSauce(Sauce.ALFREDO);
            testPizza.setExtraSauce(true);
            testPizza.setExtraCheese(false);

            ArrayList <Topping> add_toppings = new ArrayList<>();
            add_toppings.add(Topping.HAM);
            add_toppings.add(Topping.ONION);
            add_toppings.add(Topping.GREENPEPPER);
            add_toppings.add(Topping.BLACKOLIVES);
            testPizza.setToppings(add_toppings);
        }

        assertEquals(13.48, testPizza.price(), 0);

    }

    /**
     * Test the price of a medium pizza, with 4 toppings, extra cheese, and extra sauce.
     */
    @org.junit.Test
    public void test_BothExtras() {
        Pizza testPizza = PizzaMaker.createPizza("BuildYourOwn");
        if (testPizza != null){
            testPizza.setPizzaSize(Size.MEDIUM);
            testPizza.setSauce(Sauce.ALFREDO);
            testPizza.setExtraSauce(true);
            testPizza.setExtraCheese(true);

            ArrayList <Topping> add_toppings = new ArrayList<>();
            add_toppings.add(Topping.HAM);
            add_toppings.add(Topping.ONION);
            add_toppings.add(Topping.GREENPEPPER);
            add_toppings.add(Topping.BLACKOLIVES);
            testPizza.setToppings(add_toppings);
        }

        assertEquals(14.48, testPizza.price(), 0);

    }
}