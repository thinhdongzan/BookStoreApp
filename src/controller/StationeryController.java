package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Stationery;

public class StationeryController {
    @FXML
    private VBox stationeryBox;

    @FXML
    private Label stationeryBrand;

    @FXML
    private ImageView stationeryImage;

    @FXML
    private Label stationeryName;

    @FXML
    private Label stationeryPrice;

    public void setData(Stationery stationery) {
        Image image = new Image(getClass().getResourceAsStream(stationery.getImageSrc()));
        stationeryImage.setImage(image);
        stationeryBrand.setText(stationery.getBrand());
        stationeryName.setText(stationery.getName());
        stationeryPrice.setText(String.valueOf(stationery.getSellingPrice()));
    }
}
