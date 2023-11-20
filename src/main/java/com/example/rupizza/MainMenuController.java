package com.example.rupizza;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenuController {
    @FXML
    private ImageView build;
    @FXML
    private ImageView specialty;
    @FXML
    private ImageView currentOrder;
    @FXML
    private ImageView storeOrders;

    @FXML
    private void initialize(){
        Image buildYourOwnImg = new Image("file:src/main/java/com/example/rupizza/images/BuildYourOwn.jpg");
        build.setImage(buildYourOwnImg);

        Image specialityImg = new Image("file:src/main/java/com/example/rupizza/images/SpecialtyPizzas.jpg");
        specialty.setImage(specialityImg);

        Image currentOrderImg = new Image("file:src/main/java/com/example/rupizza/images/CurrentOrder.jpg");
        currentOrder.setImage(currentOrderImg);

        Image storeOrderImg = new Image("file:src/main/java/com/example/rupizza/images/StoreOrders.png");
        storeOrders.setImage(storeOrderImg);

    }
}