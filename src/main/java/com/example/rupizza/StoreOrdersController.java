package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.FXPermission;

import java.util.ArrayList;

public class StoreOrdersController {
    @FXML
    private void initialize() {
        StoreOrders full_orders_list = StoreOrders.getInstance();
        ObservableList<Integer> order_numbers = FXCollections.observableArrayList();
        ArrayList<Order> orders = StoreOrders.getStore_orders();
        for (int i = 0; i < orders.size(); i++) {
            order_numbers.add(i+1);
        }

    }
}
