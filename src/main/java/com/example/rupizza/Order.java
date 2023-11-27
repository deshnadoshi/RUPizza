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

    public static void removePizza(Pizza remove_order){
        all_orders.remove(remove_order);
    }

    public static int getOrderNumber(){
        return orderNumber;
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

    public String toString(){
        String retString = "";
        for (int i = 0; i < all_orders.size(); i++){
            retString += (all_orders.get(i).toString() + "\n") ;
        }

        return retString;
    }

}
