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
    private Pizza new_order = null;
    @FXML
    private ImageView byoImg;
    private Order current_order = null;
    private ArrayList <Pizza> my_pizzas = new ArrayList<>();

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
                byoOrder.setText("You cannot select more than 7 toppings. You must select a sauce and size to see the price of the pizza.");
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
    private void clearOrder(){
        initialize();
        // byoOrder.clear();
        byoPrice.clear();
        byoSize.getToggles().forEach(toggle -> toggle.setSelected(false));
        byoSauce.getToggles().forEach(toggle -> toggle.setSelected(false));
        byoExSauce.setSelected(false);
        byoExCheese.setSelected(false);
        chosen_toppings.clear();
    }

    @FXML
    private void calculatePrice(){
        double pizzaPrice = 0.0;
        RadioButton selectedSize = (RadioButton) byoSize.getSelectedToggle();
        RadioButton selectedSauce = (RadioButton) byoSauce.getSelectedToggle();

        if (selectedSize != null && selectedSauce != null){
            new_order = PizzaMaker.createPizza("BuildYourOwn");
        }

        if (new_order != null && selectedSize != null && selectedSauce != null){
            new_order.setPizzaSize(selectedSize());
            new_order.setSauce(selectedSauce());

            pizzaPrice += new_order.price();
        }

        if (chosen_toppings.size() > 3){
            for (int i = 4; i <= chosen_toppings.size(); i++){
                pizzaPrice += 1.49;
            }
        }

        if (byoExCheese.isSelected() && new_order != null){
            new_order.setExtraCheese(true);
            pizzaPrice += 1;
        } else if (!byoExCheese.isSelected() && new_order != null){
            new_order.setExtraCheese(false);
        }
        if (byoExSauce.isSelected() && new_order != null){
            new_order.setExtraSauce(true);
            pizzaPrice += 1;
        } else if (!byoExSauce.isSelected() && new_order != null){
            new_order.setExtraSauce(false);
        }
        if (new_order != null){
            new_order.setPrice(pizzaPrice);
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
        if (chosen_toppings != null && !chosen_toppings.isEmpty()){
            for (int i = 0; i < chosen_toppings.size(); i++){
                String topping_name = chosen_toppings.get(i).toLowerCase();
                for (Topping topping : Topping.values()){
                    String topping_enum = topping.toString().toLowerCase();
                    if(topping_name.equals(topping_enum)){
                        pizza_toppings.add(topping);
                    }
                }
            }
        }
        if (new_order != null){
            new_order.setToppings(pizza_toppings);
        }

    }

    @FXML
    private void addToOrder(ActionEvent event){
        if (new_order != null){
            setSelectedToppings();
            my_pizzas.add(new_order);
            current_order = new Order(1, my_pizzas);

            byoOrder.appendText("\n" + new_order.toString());
            byoOrder.appendText("\nThis pizza was added to your order!");
            byoOrder.appendText("\nHere is your complete order: ");
            byoOrder.appendText(current_order.toString());
        } else {
            byoOrder.appendText("Missing pizza information. Please customize your pizza.");
        }

    }


}
