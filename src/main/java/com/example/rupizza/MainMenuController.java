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

/**
 * Controller for the MainMenu.fxml class.
 * @author Haejin Song, Deshna Doshi
 */


public class MainMenuController {
    @FXML
    private ImageView build;
    @FXML
    private ImageView specialty;
    @FXML
    private ImageView currentOrder;
    @FXML
    private ImageView storeOrders;

    /**
     * Initializes the view for MainMenu.fxml
     */
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

    /**
     * Navigates to the BuildYourOwn.fxml screen.
     * @param event The action of clicking the BuildYourOwn button.
     * @throws Exception Error checking for button click issues.
     */
    @FXML
    private void goToBuildYourOwn(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BuildYourOwn.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("BuildYourOwn");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigates to CurrentOrder.fxml screen.
     * @param event The action of clicking the CurrentOrder button.
     * @throws Exception Error checking for button click issues.
     */
    @FXML
    private void goToCurrentOrder(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CurrentOrder.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("CurrentOrder");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigates to SpecialtyPizzas.fxml screen.
     * @param event The action of clicking the SpecialtyPizzas button.
     * @throws Exception Error checking for button click issues.
     */
    @FXML
    private void goToSpecialtyPizzas(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpecialtyPizzas.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("SpecialtyPizzas");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigates to StoreOrders.fxml screen.
     * @param event The action of clicking the StoreOrders button.
     * @throws Exception Error checking for button click issues.
     */
    @FXML
    private void goToStoreOrders(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreOrders.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("StoreOrders");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}