package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login_12_Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginBtnAction() {
        try {
            String username = usernameField.getText();
            String password = passwordField.getText();

            boolean isValidUser = dao.CustomerDAO.checkLogin(username, password);

            if (isValidUser) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/CUS_Menu_1.fxml"));
                root = loader.load();

                // Get the current stage and set the new scene
                stage = (Stage) usernameField.getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
