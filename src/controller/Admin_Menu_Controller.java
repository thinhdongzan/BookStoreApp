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
import javafx.scene.layout.VBox;
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
    private VBox order_page;

    @FXML
    private VBox menu_page;

    @FXML
    private Button menu_button;

    public void showMenuPage(ActionEvent event) {
        if (event.getSource() == menu_button) {

            menu_page.setVisible(true);
            order_page.setVisible(false);
            // dashboard_page.setVisible(false);
            // employee_page.setVisible(false);
            // storage_page.setVisible(false);

        }
         else if (event.getSource() == dashboard_button) {
            menu_page.setVisible(false);
            order_page.setVisible(false);
            // dashboard_page.setVisible(true);
            // employee_page.setVisible(false);
            // storage_page.setVisible(false);
        }
        else if (event.getSource() == order_button) {
            menu_page.setVisible(false);
            order_page.setVisible(true);
            // dashboard_page.setVisible(false);
            // employee_page.setVisible(false);
            // storage_page.setVisible(false);
        }
        else if (event.getSource() == employee_button) {
            menu_page.setVisible(false);
            order_page.setVisible(false);
            // dashboard_page.setVisible(false);
            // employee_page.setVisible(true);
            // storage_page.setVisible(false);
        }
        else if (event.getSource() == storage_button) {
            menu_page.setVisible(false);
            order_page.setVisible(false);
            // dashboard_page.setVisible(false);
            // employee_page.setVisible(false);
            // storage_page.setVisible(true);
        }
        
    }

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