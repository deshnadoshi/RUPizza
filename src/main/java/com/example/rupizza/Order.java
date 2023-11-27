package com.example.rupizza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Order {
    private static int orderNumber = 0;
    private static Order orderObject;
    private static ArrayList <Pizza> all_orders;
    private Order(){
        Order.orderNumber = orderNumber + 1;
        Order.all_orders = new ArrayList<Pizza>();
    }

    public static Order getInstance() {
        if (orderObject == null) {
            orderObject = new Order();
        }
        return orderObject;
    }

    public static void addPizza(Pizza new_order){
        all_orders.add(new_order);
    }

    public static void removePizza(int index){
        all_orders.remove(index);
    }

    public static String getOrderNumber(){
        return String.valueOf(orderNumber);
    }

    public static int findPizza(String pizza) {
        for (int i = 0; i < all_orders.size(); i++) {
            if (pizza.equals(all_orders.get(i).toString())) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<Pizza> getAllOrders() {
        return all_orders;
    }

    public ObservableList<String> toStringArray() {
        ObservableList<String> stringList = FXCollections.observableArrayList();
        for (int i = 0; i < all_orders.size(); i++) {
            stringList.add(String.valueOf(all_orders.get(i)));
        }
        return stringList;
    }

    public String allOrdersToString(){
        String retString = "";
        for (int i = 0; i < all_orders.size(); i++){
            retString += (all_orders.get(i).toString() + "\n") ;
        }

        return retString;
    }

}
