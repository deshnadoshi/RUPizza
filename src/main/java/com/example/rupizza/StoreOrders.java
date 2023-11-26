package com.example.rupizza;

import java.util.ArrayList;

public class StoreOrders {
    public static int nextOrderNumber;
    ArrayList <Order> store_orders = new ArrayList<>();
    public StoreOrders(int nextOrderNumber, ArrayList <Order> store_orders){
        this.store_orders = store_orders;
        this.nextOrderNumber = nextOrderNumber;
    }



    public void export(){
        // to export the orders to a file
    }
}
