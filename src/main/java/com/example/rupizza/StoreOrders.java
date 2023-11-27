package com.example.rupizza;

import java.util.ArrayList;

public class StoreOrders {
    private static int nextOrderNumber = 0;
    private static StoreOrders storeOrderObject;
    private static ArrayList <Order> store_orders = new ArrayList<>();
    private StoreOrders(){
        StoreOrders.nextOrderNumber = nextOrderNumber + 1;
        StoreOrders.store_orders = new ArrayList<Order>();
    }

    public static StoreOrders getInstance() {
        if (storeOrderObject == null) {
            storeOrderObject = new StoreOrders();
        }
        return storeOrderObject;
    }

    public static void addOrder(Order order) {
        store_orders.add(order);
    }

    public static ArrayList<Order> getStore_orders() {
        return store_orders;
    }

    public void export(){
        // to export the orders to a file
    }
}
