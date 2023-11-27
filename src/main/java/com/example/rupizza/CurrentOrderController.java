package com.example.rupizza;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class CurrentOrderController {
    @FXML
    private ListView coOrder;
    @FXML
    private TextArea coPreTaxTotal;
    @FXML
    private TextArea coTax;
    @FXML
    private TextArea coTotalPrice;
    @FXML
    private TextArea coOrderNum;
    @FXML
    private Button coRemove;
    @FXML
    private Button coPlace;
    @FXML
    private void initialize() {
        Order currentOrder = Order.getInstance();
        ObservableList<String> current_pizzas = currentOrder.toStringArray();
        coOrder.setItems(current_pizzas);
        coOrderNum.setText(Order.getOrderNumber());
        updatePrices();
    }

    @FXML
    private void removePizza(ActionEvent event) {
        String selectedPizza = (String) coOrder.getSelectionModel().getSelectedItem();
        int indexOfPizza = Order.findPizza(selectedPizza);
        if (indexOfPizza != -1) {
            Order currentOrder = Order.getInstance();
            ObservableList<String> current_pizzas = currentOrder.toStringArray();
            current_pizzas.remove(indexOfPizza);
            Order.removePizza(indexOfPizza);
            coOrder.setItems(current_pizzas);
            updatePrices();
        }
    }

    @FXML
    private void addOrder(ActionEvent event) {
        Order currentOrder = Order.getInstance();
        StoreOrders storeOrder = StoreOrders.getInstance();
        StoreOrders.addOrder(currentOrder);
        Order.deleteOrder();
        updatePrices();
    }

    private void updatePrices() {
        ArrayList<Pizza> pizzas = Order.getAllOrders();
        double total_pre_tax_price = 0.00;
        for (int i = 0; i < pizzas.size(); i++) {
            total_pre_tax_price += pizzas.get(i).price();
        }
        coPreTaxTotal.setText(String.format("%.2f", total_pre_tax_price));
        double tax = total_pre_tax_price * 0.0625;
        coTax.setText(String.format("%.2f", tax));
        double total = tax + total_pre_tax_price;
        coTotalPrice.setText(String.format("%.2f", total));
    }

}
