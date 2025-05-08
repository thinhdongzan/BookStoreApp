package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Book;

public class Cus_Menu implements Initializable {

    @FXML
    private HBox bookBestSellersLayout;

    private List<Book> bestSellers;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bestSellers = new ArrayList<>(bestSellers());
        try {
            for (Book book : bestSellers) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/Book.fxml"));
                VBox box = loader.load();
                BookController bookController = loader.getController();
                bookController.setData(book);
                bookBestSellersLayout.getChildren().add(box);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Book> bestSellers() {
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setName("metamorphosis");
        book.setAuthor("Franz Kafka");
        book.setImageSrc("/view/images/Books/metamorphosis.jpg");
        books.add(book);

        book = new Book();
        book.setName("metamorphosis");
        book.setAuthor("Franz Kafka");
        book.setImageSrc("/view/images/Books/metamorphosis.jpg");
        books.add(book);

        book = new Book();
        book.setName("metamorphosis");
        book.setAuthor("Franz Kafka");
        book.setImageSrc("/view/images/Books/metamorphosis.jpg");
        books.add(book);

        book = new Book();
        book.setName("metamorphosis");
        book.setAuthor("Franz Kafka");
        book.setImageSrc("/view/images/Books/metamorphosis.jpg");
        books.add(book);

        book = new Book();
        book.setName("metamorphosis");
        book.setAuthor("Franz Kafka");
        book.setImageSrc("/view/images/Books/metamorphosis.jpg");
        books.add(book);

        book = new Book();
        book.setName("metamorphosis");
        book.setAuthor("Franz Kafka");
        book.setImageSrc("/view/images/Books/metamorphosis.jpg");
        books.add(book);

        book = new Book();
        book.setName("metamorphosis");
        book.setAuthor("Franz Kafka");
        book.setImageSrc("/view/images/Books/metamorphosis.jpg");
        books.add(book);

        book = new Book();
        book.setName("metamorphosis");
        book.setAuthor("Franz Kafka");
        book.setImageSrc("/view/images/Books/metamorphosis.jpg");
        books.add(book);

        book = new Book();
        book.setName("metamorphosis");
        book.setAuthor("Franz Kafka");
        book.setImageSrc("/view/images/Books/metamorphosis.jpg");
        books.add(book);

        book = new Book();
        book.setName("metamorphosis");
        book.setAuthor("Franz Kafka");
        book.setImageSrc("/view/images/Books/metamorphosis.jpg");
        books.add(book);

        book = new Book();
        book.setName("metamorphosis");
        book.setAuthor("Franz Kafka");
        book.setImageSrc("/view/images/Books/metamorphosis.jpg");
        books.add(book);

        return books;
    }

    public void bookChoose() throws IOException {
        System.out.println("bookChoose() called");
    }

}
