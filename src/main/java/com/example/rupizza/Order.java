package com.example.rupizza;
import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList <String> all_orders;
    public Order(int orderNumber, ArrayList <String> all_orders){
        this.orderNumber = orderNumber;
        this.all_orders = all_orders;
    }

    public boolean addOrder(String new_order){
        all_orders.add(new_order);
        return true;
    }

    public boolean removeOrder(String remove_order){
        all_orders.remove(remove_order);
        return true;
    }

    public int getOrderNumber(){

        return 0;
    }
}
