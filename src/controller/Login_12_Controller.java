package controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.PopUpNoti;

public class Login_12_Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    /*
     * public void handleBackBtnAction(ActionEvent event) throws IOException {
     * Parent root =
     * FXMLLoader.load(getClass().getResource("../view/fxml/Login_1.1.fxml"));
     * Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     * stage.setScene(new Scene(root));
     * stage.show();
     * }
     */

    // Login button action
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/Cus_Menu.fxml"));
                root = loader.load();

                // Get the current stage and set the new scene
                stage = (Stage) usernameField.getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                stage.centerOnScreen();
            } else {
                PopUpNoti.showAlert("Invalid username or password. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Change to Register page
    @FXML
    private Pane paneCover;
    private boolean isMovedLeft = false;

    @FXML
    private void handleMove() {
        TranslateTransition transition = new TranslateTransition(Duration.millis(400), paneCover);

        if (!isMovedLeft) {
            transition.setByX(-400);
        } else {
            transition.setByX(400);
        }
        transition.play();
        isMovedLeft = !isMovedLeft;
    }

    // Register button action
    @FXML
    private TextField nameRegField;

    @FXML
    private TextField usernameRegField;

    @FXML
    private PasswordField passRegField;

    @FXML
    private void handleRegisterBtnAction() {
        String name = nameRegField.getText();
        String username = usernameRegField.getText();
        String password = passRegField.getText();

        // Handle if emtpy fields
        if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
            PopUpNoti.showAlert("Please fill in all fields.");
            return;
        }

        // Handle if username already exists
        if (dao.CustomerDAO.checkUsernameExists(username)) {
            PopUpNoti.showAlert("Username already exists. Please choose a different one.");
            return;
        }

        // If all fields are filled and username is unique, proceed to register
        try {
            boolean isRegistered = dao.CustomerDAO.registerCustomer(username, password, name);

            if (isRegistered) {
                handleMove(); // Move back to login page
            } else {
                PopUpNoti.showAlert("Registration failed. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
