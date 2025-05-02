package controller;

import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CUS_Menu_1_Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void bookSelect(ActionEvent event) throws IOException {
        System.out.println("Book selected");
    }

    public void toySelect(ActionEvent event) throws IOException {
        System.out.println("Toy selected");
    }

    public void stationerySelect(ActionEvent event) throws IOException {
        System.out.println("Stationery selected");
    }
}
