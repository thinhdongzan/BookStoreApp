package com.example.demo2;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private Pane paneCover;
    private boolean isMovedLeft = false;

    @FXML
    private void handleMove() {
        TranslateTransition transition = new TranslateTransition(Duration.millis(400), paneCover);

        if(!isMovedLeft){
            transition.setByX(-400);
        } else {
            transition.setByX(400);
        }
        transition.play();
        isMovedLeft = !isMovedLeft;
    }
}
