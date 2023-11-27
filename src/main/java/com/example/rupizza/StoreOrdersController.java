package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.util.FXPermission;
import java.util.ArrayList;

public class StoreOrdersController {
    @FXML
    private ListView soOrderView;
    @FXML
    private ChoiceBox soOrderNum;
    @FXML
    private TextArea soOrderPrice;
    @FXML
    private Button soExport;
    @FXML
    private Button soCancel;
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

    @FXML
    private void cancel(ActionEvent event) {
        String selectedOrderNumber = String.valueOf(soOrderNum.getSelectionModel().getSelectedItem());
        ObservableList numbers = soOrderNum.getItems();
        ObservableList<String> orderNumbers = FXCollections.observableArrayList();
        for (int i = 0; i < numbers.size(); i++) {
            orderNumbers.add(String.valueOf(numbers.get(i)));
        }
        int indexOfOrder = orderNumbers.indexOf(selectedOrderNumber);
        StoreOrders storeOrder = StoreOrders.getInstance();
        storeOrder.deleteOrder(indexOfOrder);
        soOrderNum.setItems(FXCollections.observableArrayList());
        soOrderPrice.setText("");
    }

    private void getOrder() {
        String selectedOrderNumber = String.valueOf(soOrderNum.getSelectionModel().getSelectedItem());
        ObservableList numbers = soOrderNum.getItems();
        ObservableList<String> orderNumbers = FXCollections.observableArrayList();
        for (int i = 0; i < numbers.size(); i++) {
            orderNumbers.add(String.valueOf(numbers.get(i)));
        }
        int indexOfOrder = orderNumbers.indexOf(selectedOrderNumber);
        if (indexOfOrder != -1) {
            StoreOrders storeOrder = StoreOrders.getInstance();
            Order selectedOrder = storeOrder.findOrder(indexOfOrder);
            ObservableList<String> pizzas = selectedOrder.toStringArray();
            soOrderView.setItems(pizzas);
            getPrice(selectedOrder);
        }
    }

    private void getPrice(Order order) {
        ArrayList<Pizza> pizzas = order.getAllOrders();
        double total_pre_tax_price = 0.00;
        for (int i = 0; i < pizzas.size(); i++) {
            total_pre_tax_price += pizzas.get(i).price();
        }
        double tax = total_pre_tax_price * 0.0625;
        double total = tax + total_pre_tax_price;
        soOrderPrice.setText(String.format("%.2f", total));
    }
}
