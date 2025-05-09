package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Admin_Menu_Controller {

    @FXML
    private HBox admin_box;

    @FXML
    private HBox dashboard_bar;

    @FXML
    private Button dashboard_button;

    @FXML
    private HBox employee_bar;

    @FXML
    private Button employee_button;

    @FXML
    private BarChart<?, ?> income_dashboard;

    @FXML
    private HBox menu_bar;

    @FXML
    private HBox order_bar;

    @FXML
    private Button order_button;

    @FXML
    private LineChart<?, ?> order_dashboard;

    @FXML
    private Pane search_bar;

    @FXML
    private TextField serach_field;

    @FXML
    private HBox sign_out;

    @FXML
    private Button sign_out_button;

    @FXML
    private HBox storage_bar;

    @FXML
    private Button storage_button;

    @FXML
    public void logout(ActionEvent event) {
        try {
            if (event.getSource() == sign_out_button) {
                // TO SWAP FROM DASHBOARD TO LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("/view/fxml/Login_1.1.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

                sign_out_button.getScene().getWindow().hide();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}