package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dao.BookDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Book;

public class Cus_Menu implements Initializable {

    @FXML
    private HBox bookBestSellersLayout;

    @FXML
    private FlowPane bookRecommendedForYouLayout;

    private List<Book> bestSellers;
    private List<Book> recommendedForYou;

    @FXML
    private Pane cartPane;

    @FXML
    private Pane comicPane;

    @FXML
    private Pane fairyTailePane;

    @FXML
    private Pane helpPane;

    @FXML
    private Pane horrorPane;

    @FXML
    private Pane novelPane;

    @FXML
    private Pane romancePane;

    @FXML
    private Pane selfHelpPane;

    @FXML
    private Pane stationeryPane;

    @FXML
    private Pane toyPane;

    @FXML
    private Pane accountPane;

    @FXML
    private Pane adventurePane;

    @FXML
    private Pane bookPane;

    public void choosePane(Pane pane) {
        bookPane.setVisible(false);
        stationeryPane.setVisible(false);
        toyPane.setVisible(false);
        cartPane.setVisible(false);
        accountPane.setVisible(false);
        helpPane.setVisible(false);
        selfHelpPane.setVisible(false);
        novelPane.setVisible(false);
        romancePane.setVisible(false);
        horrorPane.setVisible(false);
        fairyTailePane.setVisible(false);
        comicPane.setVisible(false);
        adventurePane.setVisible(false);

        bookPane.setDisable(true);
        stationeryPane.setDisable(true);
        toyPane.setDisable(true);
        cartPane.setDisable(true);
        accountPane.setDisable(true);
        helpPane.setDisable(true);
        selfHelpPane.setDisable(true);
        novelPane.setDisable(true);
        romancePane.setDisable(true);
        horrorPane.setDisable(true);
        fairyTailePane.setDisable(true);
        comicPane.setDisable(true);
        adventurePane.setDisable(true);

        pane.setVisible(true);
        pane.setDisable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setSelectedNav(bookNav);
        choosePane(bookPane);
        bestSellers = BookDAO.getBestSeller();
        try {
            for (Book book : bestSellers) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/Book.fxml"));
                VBox box = loader.load();
                BookController bookController = loader.getController();
                bookController.setData(book);
                bookBestSellersLayout.getChildren().add(box);
            }
            bookBestSellersLayout.setSpacing(10); // Khoảng cách giữa các VBox
            bookBestSellersLayout.setPrefWidth(bestSellers.size() * 200); // 200 là kích thước mỗi VBox + khoảng cách

        } catch (IOException e) {
            e.printStackTrace();
        }

        recommendedForYou = BookDAO.getRecommendedForYou();
        try {
            for (Book book : recommendedForYou) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/Book.fxml"));
                VBox box = loader.load();
                BookController bookController = loader.getController();
                bookController.setData(book);
                box.setPrefWidth(150);
                box.setPrefHeight(200);
                bookRecommendedForYouLayout.getChildren().add(box);
            }
            bookRecommendedForYouLayout.setPrefWidth(recommendedForYou.size() * 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bookChoose() throws IOException {
        setSelectedNav(bookNav);
        choosePane(bookPane);
    }

    public void stationeryChoose() throws IOException {
        setSelectedNav(stationeryNav);
        choosePane(stationeryPane);
    }

    public void toyChoose() throws IOException {
        setSelectedNav(toyNav);
        choosePane(toyPane);
    }

    public void cartChoose() throws IOException {
        setSelectedNav(cartNav);
        choosePane(cartPane);
    }

    public void accountChoose() throws IOException {
        setSelectedNav(accountNav);
        choosePane(accountPane);
    }

    public void helpChoose() throws IOException {
        setSelectedNav(helpNav);
        choosePane(helpPane);
    }

    public void selfHelpChoose() throws IOException {
        choosePane(selfHelpPane);
    }

    public void sortSelfHelpBook() throws IOException {
        choosePane(selfHelpPane);
    }

    public void sortComicBook() throws IOException {
        choosePane(comicPane);
    }

    public void sortFairyTaleBook() throws IOException {
        choosePane(fairyTailePane);
    }

    public void sortHorrorBook() throws IOException {
        choosePane(horrorPane);
    }

    public void sortNovelBook() throws IOException {
        choosePane(novelPane);
    }

    public void sortRomanceBook() throws IOException {
        choosePane(romancePane);
    }

    public void sortAdventureBook() throws IOException {
        choosePane(adventurePane);
    }

    // Search
    @FXML
    private TextField searchBar;

    public void searchOnAction(ActionEvent event) {
        System.out.println("You search: " + searchBar.getText());
    }

    // Nav
    @FXML
    private HBox bookNav;
    @FXML
    private HBox stationeryNav;
    @FXML
    private HBox toyNav;
    @FXML
    private HBox cartNav;
    @FXML
    private HBox accountNav;
    @FXML
    private HBox helpNav;

    private void setSelectedNav(HBox selected) {
        // Remove "selected" from all navs
        bookNav.getStyleClass().remove("selected");
        stationeryNav.getStyleClass().remove("selected");
        toyNav.getStyleClass().remove("selected");
        cartNav.getStyleClass().remove("selected");
        accountNav.getStyleClass().remove("selected");
        helpNav.getStyleClass().remove("selected");

        // Add "selected" to the chosen one if not already present
        if (!selected.getStyleClass().contains("selected")) {
            selected.getStyleClass().add("selected");
        }
    }

}
