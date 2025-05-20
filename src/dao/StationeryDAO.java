package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Stationery;

public class StationeryDAO {
    public static List<Stationery> getAllStationery() {
        List<Stationery> stationeryList = new ArrayList<>();
        String query = "SELECT name, brand, sellingPrice, ImageSrc FROM stationery";
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Stationery stationery = new Stationery();
                stationery.setName(rs.getString("name"));
                stationery.setBrand(rs.getString("brand"));
                stationery.setImageSrc(rs.getString("ImageSrc"));
                stationery.setSellingPrice(rs.getDouble("sellingPrice"));
                stationeryList.add(stationery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stationeryList;
    }

}
