package com.example.rupizza;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

/**
 * Controller for the CurrentOrder.fxml class.
 * @author Haejin Song, Deshna Doshi
 */


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

    /**
     * Initializes the view for CurrentOrder.fxml
     */
    @FXML
    private void initialize() {
        Order currentOrder = Order.getInstance();
        ObservableList<String> current_pizzas = currentOrder.toStringArray();
        coOrder.setItems(current_pizzas);
        coOrderNum.setText(currentOrder.getOrderNumber());
        updatePrices();
    }

    /**
     * Removes a pizza from the current order.
     * @param event Action of clicking the Remove Pizza button.
     */
    @FXML
    private void removePizza(ActionEvent event) {
        String selectedPizza = (String) coOrder.getSelectionModel().getSelectedItem();
        Order order = Order.getInstance();
        int indexOfPizza = order.findPizza(selectedPizza);
        if (indexOfPizza != -1) {
            Order currentOrder = Order.getInstance();
            ObservableList<String> current_pizzas = currentOrder.toStringArray();
            current_pizzas.remove(indexOfPizza);
            currentOrder.removePizza(indexOfPizza);
            coOrder.setItems(current_pizzas);
            updatePrices();
        }
    }

    /**
     * Place the order.
     * @param event Action of clicking the Place Order button.
     */
    @FXML
    private void addOrder(ActionEvent event) {
        Order currentOrder = Order.getInstance();
        StoreOrders storeOrder = StoreOrders.getInstance();
        if (!currentOrder.getAllOrders().isEmpty()) {
            System.out.println(currentOrder);
            System.out.println(currentOrder.getAllOrders());
            storeOrder.addOrder(currentOrder);
            currentOrder.deleteOrder();
            coOrder.setItems(null);
            updatePrices();
        } else {
            Alert noPizzas = new Alert(Alert.AlertType.ERROR);
            noPizzas.setContentText("Add a pizza to your order.");
            noPizzas.show();
        }

    }

    /**
     * Update the prices of the order.
     */
    private void updatePrices() {
        Order order = Order.getInstance();
        ArrayList<Pizza> pizzas = order.getAllOrders();
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
