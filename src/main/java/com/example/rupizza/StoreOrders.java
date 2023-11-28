package com.example.rupizza;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public void deleteOrder(int i) {
        store_orders.remove(i);
    }

    public ArrayList<Order> getStore_orders() {
        return store_orders;
    }

    public static void export(ArrayList <Order> all_orders, File file){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            int orderNum = 0;
            for (Order item : all_orders) {
                orderNum += 1;
                for (int i = 0; i < item.getAllOrders().size(); i++){


                    writer.write("#" + orderNum + ": " + item.getAllOrders().get(i).toString());
                    writer.newLine();
                }


            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
