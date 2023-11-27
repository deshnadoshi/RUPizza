package com.example.rupizza;

import java.util.ArrayList;

public class StoreOrders {
    private int nextOrderNumber = 0;
    private static StoreOrders storeOrderObject;
    private ArrayList <Order> store_orders = new ArrayList<>();
    private StoreOrders(){
        store_orders = new ArrayList<Order>();
    }

    public static StoreOrders getInstance() {
        if (storeOrderObject == null) {
            storeOrderObject = new StoreOrders();
        }
        return storeOrderObject;
    }

    public int getNextOrderNumber() {
        nextOrderNumber += 1;
        return nextOrderNumber;
    }

    public void addOrder(Order order) {
        store_orders.add(order);
    }

    public Order findOrder(int i) {
        return store_orders.get(i);
    }

    public ArrayList<Order> getStore_orders() {
        return store_orders;
    }

    public void export(){
        // to export the orders to a file
    }
}
