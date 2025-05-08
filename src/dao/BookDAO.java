package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
}
