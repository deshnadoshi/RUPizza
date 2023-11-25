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
    private void initialize() {
        ObservableList<String> pizza_types =
                FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");
        pizza_options.setItems(pizza_types);
        pizza_options.getSelectionModel().select(0);
        ObservableList<String> pizza_toppings =
                FXCollections.observableArrayList("Sausage", "Green Pepper", "Onion", "Pepperoni", "Mushroom");
        toppings.setItems(pizza_toppings);
        specialtyImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/specialtyDeluxe.png"));
        specialtySauce.setText("tomato");
        pizza_options.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("Deluxe")) {
                toppings.getItems().setAll("Sausage", "Green Pepper", "Onion", "Pepperoni", "Mushroom");
                specialtyImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/specialtyDeluxe.png"));
                specialtySauce.setText("tomato");
            } else if (newValue.equals("Supreme")) {
                toppings.getItems().setAll("Sausage", "Pepperoni", "Ham", "Green Pepper", "Onion", "Black Olive", "Mushroom");
                specialtyImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/specialtySupreme.png"));
                specialtySauce.setText("tomato");
            } else if (newValue.equals("Meatzza")) {
                toppings.getItems().setAll("Sausage", "Pepperoni", "Beef", "Ham");
                specialtyImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/specialtyMeatzza.jpg"));
                specialtySauce.setText("tomato");
            } else if (newValue.equals("Seafood")){
                toppings.getItems().setAll("Shrimp", "Squid", "Crab Meats");
                specialtyImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/specialtySeafood.jpg"));
                specialtySauce.setText("alfredo");
            } else if (newValue.equals("Pepperoni")){
                toppings.getItems().setAll("Pepperoni");
                specialtyImg.setImage(new Image("file:src/main/java/com/example/rupizza/images/specialtyPepperoni.jpg"));
                specialtySauce.setText("tomato");
            }
        });
        //toppings.getSelectionModel().select(0);
    }

    @FXML
    private void addToOrder(ActionEvent event) {

    }

    @FXML
    private void setToppings(ActionEvent event){

    }

    @FXML
    private void calculatePrice(ActionEvent event){
        pizza_options.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String pizzaType = pizza_options.getValue().toString();
            if (pizzaType.equals("Deluxe")){

            } else if (pizzaType.equals("Supreme")){

            } else if (pizzaType.equals("Meatzza")){

            } else if (pizzaType.equals("Seafood")){

            } else if (pizzaType.equals("Pepperoni")){

            }

        });

    }

    @FXML
    private boolean selectedExtraSauce(){
        return false;
    }

    @FXML
    private boolean selectedExtraCheese(){

        return checkBox.isSelected();
    }
}
