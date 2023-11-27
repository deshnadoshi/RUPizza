package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.util.FXPermission;

import java.util.ArrayList;

public class StoreOrdersController {
    @FXML
    private ListView soOrderView;
    @FXML
    private ChoiceBox soOrderNum;
    @FXML
    private void initialize() {
        StoreOrders storeOrder = StoreOrders.getInstance();
        ObservableList<Order> all_orders = FXCollections.observableArrayList();
        ObservableList<Integer> order_numbers = FXCollections.observableArrayList();
        ArrayList<Order> orders = storeOrder.getStore_orders();
        for (int i = 0; i < orders.size(); i++) {
            order_numbers.add(i+1);
            all_orders.add(orders.get(i));
        }
        soOrderNum.setItems(order_numbers);
        soOrderNum.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            getOrder();
        });
    }

    //@FXML
    private void getOrder() {
        int selectedOrderNumber = (int) soOrderNum.getSelectionModel().getSelectedItem();
        System.out.println(selectedOrderNumber);
        StoreOrders storeOrder = StoreOrders.getInstance();
        Order selectedOrder = storeOrder.findOrder(selectedOrderNumber-1);
        System.out.println(selectedOrder);
        ObservableList<String> pizzas = selectedOrder.toStringArray();
        System.out.println(pizzas);
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println("the for loop works");
            System.out.println(pizzas.get(i));
        }
        soOrderView.setItems(pizzas);
    }
}
