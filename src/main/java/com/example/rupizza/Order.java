package com.example.rupizza;
import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList <Pizza> all_orders;
    public Order(int orderNumber, ArrayList <Pizza> all_orders){
        this.orderNumber = orderNumber;
        this.all_orders = all_orders;
    }

    public boolean addOrder(Pizza new_order){
        all_orders.add(new_order);
        return true;
    }

    public boolean removeOrder(Pizza remove_order){
        all_orders.remove(remove_order);
        return true;
    }

    public int getOrderNumber(){
        return orderNumber;
    }

    public String toString(){
        String retString = "";
        for (int i = 0; i < all_orders.size(); i++){
            retString += (all_orders.get(i).toString() + "\n") ;
        }

        return retString;
    }

}
