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
import java.util.ArrayList;

/**
 * Controller for the SpecialtyPizzas.fxml class.
 * @author Haejin Song, Deshna Doshi
 */

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
    @FXML
    private TextArea specialtyNotif;
    @FXML
    private Button specialtyAdd;
    private ArrayList<Pizza> my_pizzas = new ArrayList<>();
    private Order current_order;

    /**
     * Initialize the view for SpecialtyPizzas.fxml
     */
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

    /**
     * Calculate the price of a specialty pizza.
     */
    @FXML
    private void calculatePrice(){
        double pizzaPrice = 0;
        Pizza temp = null;
        String pizzaType = pizza_options.getValue().toString();
        RadioButton selectedSize = (RadioButton) specialtySize.getSelectedToggle();
        if (selectedSize == null){
            specialtyAdd.setDisable(true);
            specialtyNotif.appendText("Please select a size to add the pizza to your order.");
        } else {
            specialtyAdd.setDisable(false);
        }
        if (selectedSize != null){
            temp = PizzaMaker.createPizza(pizzaType);
        }
        if (temp != null){
            temp.setPizzaSize(selectedSize());
            pizzaPrice = temp.price();
        }
        updatePrice(pizzaPrice);
        if (specialtyExCheese.isSelected()){
            pizzaPrice += 1;
        }
        if (specialtyExSauce.isSelected()){
            pizzaPrice += 1;
        }
        if (pizzaPrice == 0){
            specialtyPrice.setText("Please select a size.");
        } else {
            specialtyPrice.setText("" + pizzaPrice);
        }
        updatePrice(pizzaPrice);
    }

    /**
     * Determine if extra sauce has been selected.
     * @return True if it has been selected, false otherwise.
     */
    @FXML
    private boolean selectedExtraSauce(){
        return specialtyExSauce.isSelected();
    }

    /**
     * Determine if extra cheese has been selected.
     * @return True if it has been selected, false otherwise.
     */
    @FXML
    private boolean selectedExtraCheese(){
        return specialtyExCheese.isSelected();
    }

    /**
     * Determines the selected size of the pizza.
     * @return Size of the pizza.
     */
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

    /**
     * Updates the price of the pizza with the extra cheese and extra sauce parameters.
     * @param price The total price calculated so far.
     */
    @FXML
    private void updatePrice(double price){
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

    /**
     * Updates the price if extra sauce is selected.
     * @param totalPrice Total price calcuated so far.
     * @return Total price including the extra sauce price.
     */
    @FXML
    private double updateExtraSaucePrice(double totalPrice){
        return specialtyExSauce.isSelected() ? totalPrice + 1.0 : totalPrice;
    }

    /**
     * Updates the price if extra cheese is selected.
     * @param totalPrice Total price calcuated so far.
     * @return Total price including the extra cheese price.
     */
    @FXML
    private double updateExtraCheesePrice(double totalPrice){
        return specialtyExCheese.isSelected() ? totalPrice + 1.0 : totalPrice;
    }

    /**
     * Provides the price of the pizza.
     * @return a String of the price of the pizza.
     */
    @FXML
    public String getPrice(){
        return specialtyPrice.getText().toString();
    }

    /**
     * Add a specialty pizza to your order.
     */
    @FXML
    private void addToOrder(){
        String pizzaType = pizza_options.getValue().toString();
        Pizza new_pizza = PizzaMaker.createPizza(pizzaType);

        if (new_pizza != null){
            new_pizza.setExtraSauce(selectedExtraSauce());
            new_pizza.setExtraCheese(selectedExtraCheese());
            new_pizza.setPizzaSize(selectedSize());

            Double price = Double.parseDouble(specialtyPrice.getText());
            new_pizza.setPrice(price);

            my_pizzas.add(new_pizza);

            current_order = Order.getInstance();
            current_order.addPizza(new_pizza);

            specialtyNotif.appendText("\n" + new_pizza.toString());
            specialtyNotif.appendText("\nThis pizza was added to your order!");
            specialtyNotif.appendText("\nHere is your complete order: ");
            specialtyNotif.appendText(current_order.allOrdersToString());

        }

    }
}
