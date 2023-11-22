package com.example.rupizza;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.*;
import javafx.stage.*;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

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

    @FXML
    private void goToBuildYourOwn(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BuildYourOwn.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToCurrentOrder(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CurrentOrder.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToSpecialtyPizzas(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpecialtyPizzas.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToStoreOrders(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreOrders.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}