package com.example.rupizza;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.TilePane;

public class SpecialtyPizzasController {
    @FXML
    private ComboBox pizza_options;
    @FXML
    private ListView toppings;
    @FXML
    private void initialize() {
        ObservableList<String> pizza_types =
                FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");
        pizza_options.setItems(pizza_types);
        pizza_options.getSelectionModel().select(0);
        ObservableList<String> pizza_toppings =
                FXCollections.observableArrayList("Sausage", "Green Pepper", "Onion", "Pepperoni", "Mushroom");
        String selected = (String) pizza_options.getSelectionModel().getSelectedItem();
        toppings.setItems(pizza_toppings);
        //toppings.getSelectionModel().select(0);
    }

    @FXML
    private void addToOrder(ActionEvent event) {

    }
}
