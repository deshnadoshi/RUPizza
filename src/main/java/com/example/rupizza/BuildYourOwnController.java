package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.*;
import javafx.stage.*;

import java.util.ArrayList;

public class BuildYourOwnController {

    @FXML
    private ListView <String> availToppings;
    @FXML
    private ListView <String> addedToppings;
    @FXML
    private ArrayList <String> chosen_toppings = new ArrayList<>();
    @FXML
    private TextArea byoOrder;
    @FXML
    private TextArea byoPrice;
    @FXML
    private ToggleGroup byoSize;
    @FXML
    private ToggleGroup byoSauce;
    @FXML
    private CheckBox byoExSauce;
    @FXML
    private CheckBox byoExCheese;

    @FXML
    private void initialize(){
        ObservableList<String> pizza_toppings = FXCollections.observableArrayList("Green Pepper", "Onion", "Pineapple", "Black Olives", "Mushroom", "Sausage", "Chicken",
                "Beef", "Ham", "Crab Meats", "Pepperoni", "Shrimp", "Squid");
        availToppings.setItems(pizza_toppings);
        ObservableList<String> added_toppings = FXCollections.observableArrayList();
        addedToppings.setItems(added_toppings);
    }

    @FXML
    private void addToppings(ActionEvent event){
        String selectedTopping = availToppings.getSelectionModel().getSelectedItem();
        if (selectedTopping != null) {
            if (chosen_toppings.size() < 7){
                addedToppings.getItems().add(selectedTopping);
                availToppings.getItems().remove(selectedTopping);

                chosen_toppings.add(selectedTopping.toString());
                byoOrder.clear();
            } else {
                byoOrder.setText("You cannot select more than 7 toppings.");
            }

        }

    }

    @FXML
    private void removeToppings(ActionEvent event){
        String selectedTopping = addedToppings.getSelectionModel().getSelectedItem();

        if (chosen_toppings.size() <= 7){
            byoOrder.clear();
        }
        if (selectedTopping != null) {
            availToppings.getItems().add(selectedTopping);
            addedToppings.getItems().remove(selectedTopping);

            chosen_toppings.remove(selectedTopping.toString());
        }

    }

    @FXML
    private void clearOrder(ActionEvent event){
        initialize();
        byoOrder.clear();
        byoPrice.clear();
        byoSize.getToggles().forEach(toggle -> toggle.setSelected(false));
        byoSauce.getToggles().forEach(toggle -> toggle.setSelected(false));
        byoExSauce.setSelected(false);
        byoExCheese.setSelected(false);
    }




}
