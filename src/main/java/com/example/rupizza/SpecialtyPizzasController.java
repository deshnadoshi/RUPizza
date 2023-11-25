package com.example.rupizza;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class SpecialtyPizzasController {
    @FXML
    private ComboBox pizza_options;
    @FXML
    private ListView toppings;
    @FXML
    private ImageView specialtyImg;
    @FXML
    private TextArea specialtySauce;
    @FXML
    private CheckBox specialtyExSauce;
    @FXML
    private CheckBox specialtyExCheese;
    @FXML
    private ToggleGroup specialtySize;
    @FXML
    private RadioButton specialtySmall;
    @FXML
    private RadioButton specialtyMed;
    @FXML
    private RadioButton specialtyLarge;
    @FXML
    private TextArea specialtyPrice;

    private String removeExcess = "remove";

    @FXML
    private void initialize() {
        ObservableList<String> pizza_types = FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");
        pizza_options.setItems(pizza_types);
        pizza_options.getSelectionModel().select(0);
        ObservableList<String> pizza_toppings = FXCollections.observableArrayList("Sausage", "Green Pepper", "Onion", "Pepperoni", "Mushroom");
        toppings.setItems(pizza_toppings);
        specialtyImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/specialtyDeluxe.png"));
        specialtySauce.setText("tomato");
        calculatePrice();
        pizza_options.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("Deluxe")) {
                toppings.getItems().setAll("Sausage", "Green Pepper", "Onion", "Pepperoni", "Mushroom");
                specialtyImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/specialtyDeluxe.png"));
                specialtySauce.setText("tomato");
                calculatePrice();
            } else if (newValue.equals("Supreme")) {
                toppings.getItems().setAll("Sausage", "Pepperoni", "Ham", "Green Pepper", "Onion", "Black Olive", "Mushroom");
                specialtyImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/specialtySupreme.png"));
                specialtySauce.setText("tomato");
                calculatePrice();
            } else if (newValue.equals("Meatzza")) {
                toppings.getItems().setAll("Sausage", "Pepperoni", "Beef", "Ham");
                specialtyImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/specialtyMeatzza.jpg"));
                specialtySauce.setText("tomato");
                calculatePrice();
            } else if (newValue.equals("Seafood")){
                toppings.getItems().setAll("Shrimp", "Squid", "Crab Meats");
                specialtyImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/specialtySeafood.jpg"));
                specialtySauce.setText("alfredo");
                calculatePrice();
            } else if (newValue.equals("Pepperoni")){
                toppings.getItems().setAll("Pepperoni");
                specialtyImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/specialtyPepperoni.jpg"));
                specialtySauce.setText("tomato");
                calculatePrice();
            }
        });
    }

    @FXML
    private void addToOrder(ActionEvent event) {

    }

    @FXML
    private void calculatePrice(){
        double pizzaPrice = 0;
        Pizza temp = null;
        String pizzaType = pizza_options.getValue().toString();
        RadioButton selectedSize = (RadioButton) specialtySize.getSelectedToggle();
        if (selectedSize != null){
            if (pizzaType.equals("Deluxe")){
                System.out.println("del");
                temp = new Deluxe(selectedSize(), Sauce.TOMATO, selectedExtraSauce(), selectedExtraCheese());
            } else if (pizzaType.equals("Supreme")){
                System.out.println("sup");
                temp = new Supreme(selectedSize(), Sauce.TOMATO, selectedExtraSauce(), selectedExtraCheese());
            } else if (pizzaType.equals("Meatzza")){
                System.out.println("meat");
                temp = new Meatzza(selectedSize(), Sauce.TOMATO, selectedExtraSauce(), selectedExtraCheese());
            } else if (pizzaType.equals("Seafood")){
                System.out.println("sea");
                temp = new Seafood(selectedSize(), Sauce.ALFREDO, selectedExtraSauce(), selectedExtraCheese());
            } else if (pizzaType.equals("Pepperoni")){
                System.out.println("pep");
                temp = new Pepperoni(selectedSize(), Sauce.TOMATO, selectedExtraSauce(), selectedExtraCheese());
            }

        }

        if (temp != null){
            System.out.println("calculating price here");
            pizzaPrice = temp.price();

            /**
            if (selectedExtraCheese()){
                pizzaPrice += 1;
            }
            if (selectedExtraSauce()){
                pizzaPrice += 1;
            } **/

        }

        updatePrice(pizzaPrice);

        if (pizzaPrice == 0){
            specialtyPrice.setText("Please select a size.");
        } else {
            specialtyPrice.setText("" + pizzaPrice);
        }

        updatePrice(pizzaPrice);
    }

    @FXML
    private boolean selectedExtraSauce(){
        return specialtyExSauce.isSelected();
    }

    @FXML
    private boolean selectedExtraCheese(){
        return specialtyExCheese.isSelected();
    }

    @FXML
    private Size selectedSize(){
        RadioButton selectedButton = (RadioButton) specialtySize.getSelectedToggle();
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
    private void updatePrice(double price){
        System.out.println("update price called");
        specialtySize.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadioButton = (RadioButton) newValue;
                String selectedText = selectedRadioButton.getText();
                calculatePrice();
            }
        });

        specialtyExSauce.selectedProperty().addListener((observable, oldValue, newValue) -> {
            specialtyPrice.setText("" + updateExtraSaucePrice(price));
        });

        specialtyExCheese.selectedProperty().addListener((observable, oldValue, newValue) -> {
            specialtyPrice.setText("" + updateExtraCheesePrice(price));
        });



    }

    @FXML
    private double updateExtraSaucePrice(double totalPrice){
        return specialtyExSauce.isSelected() ? totalPrice + 1.0 : totalPrice;
    }
    @FXML
    private double updateExtraCheesePrice(double totalPrice){
        return specialtyExCheese.isSelected() ? totalPrice + 1.0 : totalPrice;
    }

}
