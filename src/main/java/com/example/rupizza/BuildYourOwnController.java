package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.image.Image;

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
    private Pizza temp = null;
    @FXML
    private ImageView byoImg;

    @FXML
    private void initialize(){
        ObservableList<String> pizza_toppings = FXCollections.observableArrayList("GreenPepper", "Onion", "Pineapple", "BlackOlives", "Mushroom", "Sausage", "Chicken",
                "Beef", "Ham", "CrabMeats", "Pepperoni", "Shrimp", "Squid");
        availToppings.setItems(pizza_toppings);
        ObservableList<String> added_toppings = FXCollections.observableArrayList();
        addedToppings.setItems(added_toppings);
        byoOrder.setText("Please select a size and sauce to view prices.");
        byoImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/byoPizza.jpg"));
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

            calculatePrice();
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
            calculatePrice();
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

    @FXML
    private void calculatePrice(){
        double pizzaPrice = 0.0;
        RadioButton selectedSize = (RadioButton) byoSize.getSelectedToggle();
        RadioButton selectedSauce = (RadioButton) byoSauce.getSelectedToggle();

        if (selectedSize != null && selectedSauce != null){
            temp = PizzaMaker.createPizza("BuildYourOwn");
        }

        if (temp != null && selectedSize != null && selectedSauce != null){
            temp.setPizzaSize(selectedSize());
            temp.setSauce(selectedSauce());

            pizzaPrice += temp.price();
        }

        if (chosen_toppings.size() > 3){
            for (int i = 4; i <= chosen_toppings.size(); i++){
                pizzaPrice += 1.49;
            }
        }

        if (byoExCheese.isSelected() && temp != null){
            temp.setExtraCheese(true);
            pizzaPrice += 1;
        }
        if (byoExSauce.isSelected() && temp != null){
            temp.setExtraSauce(true);
            pizzaPrice += 1;
        }
        if (temp != null){
            temp.setPrice(pizzaPrice);
        }
        byoPrice.setText("" + pizzaPrice);

    }

    @FXML
    private Size selectedSize(){
        RadioButton selectedButton = (RadioButton) byoSize.getSelectedToggle();
        if (selectedButton != null){
            String sizeName = selectedButton.getText();
            if (sizeName.equals("small")){
                return Size.SMALL;
            } else if (sizeName.equals("medium")){
                return Size.MEDIUM;
            } else if (sizeName.equals("large")){
                return Size.LARGE;
            }

        }
        return null;
    }

    @FXML
    private Sauce selectedSauce(){
        RadioButton selectedButton = (RadioButton) byoSauce.getSelectedToggle();
        if (selectedButton != null){
            String sizeName = selectedButton.getText();
            if (sizeName.equals("tomato sauce")){
                return Sauce.TOMATO;
            } else if (sizeName.equals("alfredo sauce")){
                return Sauce.ALFREDO;
            }
        }
        return null;
    }

    @FXML
    private void setSelectedToppings(){
        ArrayList <Topping> pizza_toppings = new ArrayList<>();
        if (chosen_toppings != null && chosen_toppings.size() > 0){
            for (int i = 0; i < chosen_toppings.size(); i++){
                String topping_name = chosen_toppings.get(i).toString().toLowerCase();
                for (Topping topping : Topping.values()){
                    String topping_enum = topping.toString().toLowerCase();
                    if(topping_name.equals(topping_enum)){
                        pizza_toppings.add(topping);
                    }
                }
            }
        }
        temp.setToppings(pizza_toppings);
    }



    @FXML
    private void addToOrder(ActionEvent event){

        // need to do stuff for adding to order here
    }







}
