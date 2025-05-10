package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Employee;

public class EmployeeDAO {
    public static List<Employee> showEmployee() {
        List<Employee> listEmployees  = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        // Execute the SQL query and retrieve the results
        // For each result, create a Book object and add it to the books list
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                Employee anEmployee = new Employee(
                result.getInt("id"),
                result.getString("name"),
                result.getString("email"),
                result.getString("phoneNumber"),
                result.getDouble("salary"));
                listEmployees.add(anEmployee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEmployees;
    }
}
