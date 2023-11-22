package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

public class SpecialtyPizzasController {
    @FXML
    private ComboBox pizza_options;
    @FXML
    private void initialize() {
        ObservableList<String> items =
                FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");
        pizza_options.setItems(items);
        pizza_options.getSelectionModel().select(0);

        //comboBox.getItems().removeAll(comboBox.getItems());
        //comboBox.getItems().addAll("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");
        //comboBox.getSelectionModel().select("Deluxe");
    }
}
