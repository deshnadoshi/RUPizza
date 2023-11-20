package com.example.rupizza;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenuController {
    @FXML
    private Button buildYourOwn;

    @FXML
    private void initialize(){
        ImageView buildYourOwnImg = new ImageView(new Image("file:src/main/java/com/example/rupizza/images/BuildYourOwn.jpg"));
        buildYourOwn.setGraphic(buildYourOwnImg);



    }
}