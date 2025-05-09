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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Book;

public class Cus_Menu implements Initializable {

    @FXML
    private HBox bookBestSellersLayout;

    @FXML
    private FlowPane bookRecommendedForYouLayout;

    private List<Book> bestSellers;
    private List<Book> recommendedForYou;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
                bookRecommendedForYouLayout.getChildren().add(box);
            }
            bookRecommendedForYouLayout.setPrefWidth(recommendedForYou.size() * 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bookChoose() throws IOException {
        System.out.println("bookChoose() called");
    }

}
