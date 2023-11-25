package com.example.rupizza;
import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList <String> all_orders;
    public Order(int orderNumber, ArrayList <String> all_orders){
        this.orderNumber = orderNumber;
        this.all_orders = all_orders;
    }

    public boolean addOrder(){

        return true;
    }

    public boolean removeOrder(){

        return true;
    }
}
