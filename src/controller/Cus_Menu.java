package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import dao.BookDAO;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Book;
import utils.PopUpNoti;

public class Cus_Menu implements Initializable {

    @FXML
    private HBox bookBestSellersLayout;

    @FXML
    private FlowPane bookRecommendedForYouLayout;

    private List<Book> bestSellers;
    private List<Book> recommendedForYou;

    @FXML
    private HBox bookGenres;

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

    @FXML
    private Pane mainPane;

    @FXML
    private FlowPane selfHelpLayout;

    @FXML
    private FlowPane horrorLayout;

    @FXML
    private FlowPane adventureLayout;

    @FXML
    private FlowPane novelLayout;

    @FXML
    private FlowPane romanceLayout;

    @FXML
    private FlowPane fairyTaleLayout;

    @FXML
    private FlowPane comicLayout;

    public void choosePane(Pane pane) {
        bookPane.setVisible(false);
        stationeryPane.setVisible(false);
        toyPane.setVisible(false);
        cartPane.setVisible(false);
        accountPane.setVisible(false);
        helpPane.setVisible(false);

        bookPane.setDisable(true);
        stationeryPane.setDisable(true);
        toyPane.setDisable(true);
        cartPane.setDisable(true);
        accountPane.setDisable(true);
        helpPane.setDisable(true);

        pane.setVisible(true);
        pane.setDisable(false);
    }

    public void chooseGenre(Pane pane) {
        mainPane.setVisible(false);
        selfHelpPane.setVisible(false);
        novelPane.setVisible(false);
        romancePane.setVisible(false);
        horrorPane.setVisible(false);
        fairyTailePane.setVisible(false);
        comicPane.setVisible(false);
        adventurePane.setVisible(false);

        mainPane.setDisable(true);
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
        chooseGenre(mainPane);
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
        chooseGenre(mainPane);
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
        choosePayMethod(payCreditCardPane);
    }

    public void accountChoose() throws IOException {
        setSelectedNav(accountNav);
        choosePane(accountPane);
    }

    public void helpChoose() throws IOException {
        setSelectedNav(helpNav);
        choosePane(helpPane);
    }

    public void logoutChoose(Event event) throws IOException {
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Confirm Logout",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {
                // Get the current stage
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // Load the login FXML
                Parent root = FXMLLoader.load(getClass().getResource("/view/fxml/login_1.1.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                stage.centerOnScreen();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sortSelfHelpBook() throws IOException {
        chooseGenre(selfHelpPane);
        List<Book> selfHelpBooks = BookDAO.getSelfHelp();
        selfHelpLayout.getChildren().clear(); // Clear existing books before adding new ones
        try {
            for (Book book : selfHelpBooks) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/Book.fxml"));
                VBox box = loader.load();
                BookController bookController = loader.getController();
                bookController.setData(book);
                selfHelpLayout.getChildren().add(box);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortComicBook() throws IOException {
        chooseGenre(comicPane);
        List<Book> comicBooks = BookDAO.getComic();
        comicLayout.getChildren().clear(); // Clear existing books before adding new ones
        try {
            for (Book book : comicBooks) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/Book.fxml"));
                VBox box = loader.load();
                BookController bookController = loader.getController();
                bookController.setData(book);
                comicLayout.getChildren().add(box);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortFairyTaleBook() throws IOException {
        chooseGenre(fairyTailePane);
        List<Book> fairyTaleBooks = BookDAO.getFairyTale();
        fairyTaleLayout.getChildren().clear(); // Clear existing books before adding new ones
        try {
            for (Book book : fairyTaleBooks) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/Book.fxml"));
                VBox box = loader.load();
                BookController bookController = loader.getController();
                bookController.setData(book);
                fairyTaleLayout.getChildren().add(box);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortHorrorBook() throws IOException {
        chooseGenre(horrorPane);
        List<Book> horrorBooks = BookDAO.getHorror();
        horrorLayout.getChildren().clear(); // Clear existing books before adding new ones
        try {
            for (Book book : horrorBooks) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/Book.fxml"));
                VBox box = loader.load();
                BookController bookController = loader.getController();
                bookController.setData(book);
                horrorLayout.getChildren().add(box);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortNovelBook() throws IOException {
        chooseGenre(novelPane);
        List<Book> novelBooks = BookDAO.getNovel();
        novelLayout.getChildren().clear(); // Clear existing books before adding new ones
        try {
            for (Book book : novelBooks) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/Book.fxml"));
                VBox box = loader.load();
                BookController bookController = loader.getController();
                bookController.setData(book);
                novelLayout.getChildren().add(box);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortRomanceBook() throws IOException {
        chooseGenre(romancePane);
        List<Book> romanceBooks = BookDAO.getRomance();
        romanceLayout.getChildren().clear(); // Clear existing books before adding new ones
        try {
            for (Book book : romanceBooks) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/Book.fxml"));
                VBox box = loader.load();
                BookController bookController = loader.getController();
                bookController.setData(book);
                romanceLayout.getChildren().add(box);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortAdventureBook() throws IOException {
        chooseGenre(adventurePane);
        List<Book> adventureBooks = BookDAO.getAdventure();
        adventureLayout.getChildren().clear(); // Clear existing books before adding new ones
        try {
            for (Book book : adventureBooks) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/Book.fxml"));
                VBox box = loader.load();
                BookController bookController = loader.getController();
                bookController.setData(book);
                adventureLayout.getChildren().add(box);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    @FXML
    private HBox logoutNav;

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

    // Cart
    @FXML
    private Pane payCreditCardPane;
    @FXML
    private Pane payCashPane;

    public void choosePayMethod(Pane pane) {
        payCreditCardPane.setVisible(false);
        payCashPane.setVisible(false);

        payCreditCardPane.setDisable(true);
        payCashPane.setDisable(true);

        pane.setVisible(true);
        pane.setDisable(false);
    }

    public void switchToPayCreditCard() throws IOException {
        choosePayMethod(payCreditCardPane);
    }

    public void switchToPayCash() throws IOException {
        choosePayMethod(payCashPane);
    }
}
