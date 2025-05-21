package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.Admin_Menu_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Book;

public class BookDAO {
    public static List<Book> getBestSeller() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT name, author, ImageSrc, section, sellingPrice FROM book WHERE section = 'Best Seller'";
        // Execute the SQL query and retrieve the results
        // For each result, create a Book object and add it to the books list
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setImageSrc(rs.getString("ImageSrc"));
                book.setSellingPrice(rs.getDouble("sellingPrice"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static List<Book> getRecommendedForYou() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT name, author, ImageSrc, section, sellingPrice FROM book WHERE section = 'Recommended For You'";
        // Execute the SQL query and retrieve the results
        // For each result, create a Book object and add it to the books list
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setImageSrc(rs.getString("ImageSrc"));
                book.setSellingPrice(rs.getDouble("sellingPrice"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static List<Book> getSelfHelp() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT name, author, ImageSrc, section, sellingPrice FROM book WHERE genre = 'Self-help'";
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setImageSrc(rs.getString("ImageSrc"));
                book.setSellingPrice(rs.getDouble("sellingPrice"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static List<Book> getHorror() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT name, author, ImageSrc, section, sellingPrice FROM book WHERE genre = 'Horror'";
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setImageSrc(rs.getString("ImageSrc"));
                book.setSellingPrice(rs.getDouble("sellingPrice"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static List<Book> getAdventure() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT name, author, ImageSrc, section, sellingPrice FROM book WHERE genre = 'Adventure'";
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setImageSrc(rs.getString("ImageSrc"));
                book.setSellingPrice(rs.getDouble("sellingPrice"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static List<Book> getNovel() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT name, author, ImageSrc, section, sellingPrice FROM book WHERE genre = 'Novel'";
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setImageSrc(rs.getString("ImageSrc"));
                book.setSellingPrice(rs.getDouble("sellingPrice"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static List<Book> getFairyTale() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT name, author, ImageSrc, section, sellingPrice FROM book WHERE genre = 'Fairy Tale'";
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setImageSrc(rs.getString("ImageSrc"));
                book.setSellingPrice(rs.getDouble("sellingPrice"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static List<Book> getComic() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT name, author, ImageSrc, section, sellingPrice FROM book WHERE genre = 'Comic'";
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setImageSrc(rs.getString("ImageSrc"));
                book.setSellingPrice(rs.getDouble("sellingPrice"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static List<Book> getRomance() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT name, author, ImageSrc, section, sellingPrice FROM book WHERE genre = 'Romance'";
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setImageSrc(rs.getString("ImageSrc"));
                book.setSellingPrice(rs.getDouble("sellingPrice"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;   
    }



    //FOR ADMINNNN !!!
    public static ObservableList<Book> bookDataList() {

    ObservableList<Book> listBooks = FXCollections.observableArrayList();
    String sql = "SELECT * FROM book";

    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet result = stmt.executeQuery(sql)) {

        Book book;

        while (result.next()) {
            book = new Book(
                result.getInt("id"),
                result.getString("name"),
                result.getInt("quantity"),
                result.getDouble("purchasePrice"),
                result.getDouble("sellingPrice"),
                result.getString("author"),
                result.getString("publisher"),
                result.getString("isbn")
            );
            listBooks.add(book);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listBooks;
}


     public static boolean addNewBook(Admin_Menu_Controller controller) {
        String sql = "INSERT INTO book (id, name, quantity, purchasePrice, sellingPrice, publisher, author, isbn, genre) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Lấy dữ liệu từ controller
        String id = controller.getAdd_book_id().getText();
        String name = controller.getAdd_book_name().getText();
        String quantity = controller.getAdd_book_quantity().getText();
        String purchasePrice = controller.getAdd_book_purchase_price().getText();
        String sellingPrice = controller.getAdd_book_selling_price().getText();
        String publisher = controller.getAdd_book_publisher().getText();
        String author = controller.getAdd_book_author().getText();
        String isbn = controller.getAdd_book_isbn().getText();
        String genre = controller.getAdd_book_genre().getText();

        // Kiểm tra dữ liệu rỗng
        if (id.isEmpty() || name.isEmpty() || quantity.isEmpty() || purchasePrice.isEmpty() ||
            sellingPrice.isEmpty() || publisher.isEmpty() || author.isEmpty() ||
            isbn.isEmpty() || genre.isEmpty()) {
            throw new IllegalArgumentException("Please complete all book details.");
        }

        // Kiểm tra định dạng số
        int bookId, qty;
        double priceBuy, priceSell;
        try {
            bookId = Integer.parseInt(id);
            qty = Integer.parseInt(quantity);
            priceBuy = Double.parseDouble(purchasePrice);
            priceSell = Double.parseDouble(sellingPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID, Quantity, Purchase Price và Selling Price phải là số hợp lệ.");
        }

        // Ghi vào database
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookId);
            stmt.setString(2, name);
            stmt.setInt(3, qty);
            stmt.setDouble(4, priceBuy);
            stmt.setDouble(5, priceSell);
            stmt.setString(6, publisher);
            stmt.setString(7, author);
            stmt.setString(8, isbn);
            stmt.setString(9, genre);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error while inserting new book.");
        }
    }


    public static void deleteBookById(int id) throws SQLException {
    String sql = "DELETE FROM book WHERE id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
}

    

}
