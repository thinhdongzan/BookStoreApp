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

}
