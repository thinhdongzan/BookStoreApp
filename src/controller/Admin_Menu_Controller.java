package controller;



import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.*;


import dao.DBConnection;
//import dao.DBConnection;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Book;
import model.Employee;
import model.Stationery;
import model.Toy;



public class Admin_Menu_Controller implements Initializable  {

    @FXML
    private HBox admin_box;

    @FXML
    private HBox attendances_box;

    @FXML
    private HBox dashboard_bar;

    @FXML
    private Button dashboard_button;

    @FXML
    private HBox dispactch_box;

    @FXML
    private Button e_add;

    @FXML
    private Button e_remove;

    @FXML
    private HBox employee_bar;

    @FXML
    private HBox employee_box;

    @FXML
    private Button employee_button;

    @FXML
    private VBox employee_page;

    @FXML
    private TableView<Employee> employee_table;

    // @FXML
    // private BarChart<?, ?> income_dashboard;

    @FXML
    private HBox joining_box;

    @FXML
    private HBox menu_bar;

    @FXML
    private Button menu_button;

    @FXML
    private VBox menu_page;

    @FXML
    private Pane menu_pane;

    @FXML
    private HBox odrer_box;

    @FXML
    private HBox order_bar;

    @FXML
    private Button order_button;

    // @FXML
    // private LineChart<?, ?> order_dashboard;

    @FXML
    private VBox order_page;

    @FXML
    private VBox dashboard_page;

    
    
    // @FXML
    // private TableView<?> order_table;

    @FXML
    private HBox pending_box;

    @FXML
    private Pane search_bar;

    @FXML
    private Pane search_bar1;

    @FXML
    private Pane search_bar11;

    @FXML
    private TextField serach_field;

    @FXML
    private TextField serach_field1;

    @FXML
    private TextField serach_field11;

    @FXML
    private HBox sign_out;

    @FXML
    private Button sign_out_button;

    @FXML
    private HBox storage_bar;

    @FXML
    private Button storage_button;
    
    @FXML
    private TableColumn<Employee, Integer> id_col;

    @FXML
    private TableColumn<Employee, String> name_col;

    @FXML
    private TableColumn<Employee, String> dob_col;

    @FXML
    private TableColumn<Employee, String> address_col;

    @FXML
    private TableColumn<Employee, Double> salary_col;   

    @FXML
    private Label totalEmployee_label;

     @FXML
    private Label take_dobLabel;

    @FXML
    private Label take_emailLabel;

    @FXML
    private Label take_nameLabel;

    @FXML
    private Label take_phoneLabel;

    @FXML
    private ImageView profile_image;

    @FXML
    private VBox storage_page;

    @FXML
    private TableColumn<Book, Integer> bookId_storage_col;

    @FXML
    private TableColumn<Book, String> bookIsbn_storage_col;

    @FXML
    private TableColumn<Book, String> bookName_storage_col;

    @FXML
    private TableColumn<Book, String> bookAuthor_storage_col;

    @FXML
    private TableColumn<Book, String> bookPublisher_storage_col;

    @FXML
    private TableColumn<Book, Double> bookPurchasePrice_storage_col;

    @FXML
    private TableColumn<Book, Double> bookSellingPrice_storage_col;

    @FXML
    private TableColumn<Book, Integer> bookQuantity_storage_col;
    
    @FXML
    private TableView<Book> books_table_storage;

    @FXML
    private TableView<Stationery> stationaries_table_storage;

    @FXML
    private TableView<Toy> toys_table_storage;

    @FXML
    private Button books_table_button;

    @FXML
    private Button stationaries_table_button;

    @FXML
    private Button toys_table_button;

    @FXML
    private TableColumn<Stationery, String> stationeryBrand_storage_col;

    @FXML
    private TableColumn<Stationery, Integer> stationeryId_storage_col;

    @FXML
    private TableColumn<Stationery, String> stationeryName_storage_col;

    @FXML
    private TableColumn<Stationery, Double> stationeryPruchasePrice_storage_col;

    @FXML
    private TableColumn<Stationery, Integer> stationeryQuantity_storage_col;

    @FXML
    private TableColumn<Stationery, Double> stationerySeliingPrice_storage_col;

    @FXML
    private TableColumn<Stationery, String> stationeryType_storage_col;

    @FXML
    private TableColumn<Toy, String> toyBrand_storage_col;

    @FXML
    private TableColumn<Toy, Integer> toyId_storage_col;

    @FXML
    private TableColumn<Toy, String> toyName_storage_col;
    @FXML
    private TableColumn<Toy, String> toyType_storage_col;

    @FXML
    private TableColumn<Toy, Double> toyPurchasePrice_storage_col;

    @FXML
    private TableColumn<Toy, Integer> toyQuantity_storage_col;

    @FXML
    private TableColumn<Toy, Double> toySellingPrice_storage_col;

    @FXML
    private TableColumn<Toy, String> toySuitableAge_storage_col;

    @FXML
    private Label totalEmployee_label_menu;

    @FXML
    private ComboBox<String> add_storage_button;

    @FXML
    private VBox toys_add_storage;

    @FXML
    private VBox books_add_storage;

    @FXML
    private VBox stationery_add_storage;





    private Connection connect;
    private PreparedStatement prepare;
    // private Statement statement;
    private ResultSet result;

    private Image image;




    // SHOW MENU PAGE
    public void showMenuPage(ActionEvent event) {
        if (event.getSource() == menu_button) {

            menu_page.setVisible(true);
            order_page.setVisible(false);
            dashboard_page.setVisible(false);
            employee_page.setVisible(false);
            storage_page.setVisible(false);

        }
         else if (event.getSource() == dashboard_button) {
            menu_page.setVisible(false);
            order_page.setVisible(false);
            dashboard_page.setVisible(true);
            employee_page.setVisible(false);
            storage_page.setVisible(false);
        }
        else if (event.getSource() == order_button) {
            menu_page.setVisible(false);
            order_page.setVisible(true);
            dashboard_page.setVisible(false);
            employee_page.setVisible(false);
            storage_page.setVisible(false);
        }
        else if (event.getSource() == employee_button) {
            menu_page.setVisible(false);
            order_page.setVisible(false);
            dashboard_page.setVisible(false);
            employee_page.setVisible(true);
            storage_page.setVisible(false);
        }
        else if (event.getSource() == storage_button) {
            menu_page.setVisible(false);
            order_page.setVisible(false);
            dashboard_page.setVisible(false);
            employee_page.setVisible(false);
            storage_page.setVisible(true);
        }
        else if (event.getSource() == dashboard_button) {
            menu_page.setVisible(false);
            order_page.setVisible(false);
            dashboard_page.setVisible(true);
            employee_page.setVisible(false);
            storage_page.setVisible(false);
        }
    }

    ///SHOW EMPLOYEE TABLE
    public ObservableList<Employee> dataList() {

        ObservableList<Employee> listEmployees = FXCollections.observableArrayList();

        String sql = "SELECT * FROM employee";

        //connect = Database.connectDB();

        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(sql)) {

            Employee anEmployee;

            // prepare = connect.prepareStatement(sql);
            // result = prepare.executeQuery();

            while (result.next()) {
                anEmployee = new Employee(
                result.getInt("id"),
                result.getString("name"),
                result.getString("dob"),
                result.getString("address"),
                result.getDouble("salary"),
                result.getString("image"),
                result.getString("phone"),
                result.getString("email")
                );

                listEmployees.add(anEmployee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEmployees;
    }

    private ObservableList<Employee> listEmployees;

    public void showEmployee() {

        listEmployees = dataList();

        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        dob_col.setCellValueFactory(new PropertyValueFactory<>("dob"));
        address_col.setCellValueFactory(new PropertyValueFactory<>("address"));
        salary_col.setCellValueFactory(new PropertyValueFactory<>("salary"));
        employee_table.setItems(listEmployees);

        totalEmployee_label.setText(""+listEmployees.size());
        // totalEmployee_label_menu.setText(""+listEmployees.size());
    }
    
    public void selectEmployee() {

        Employee employeeData  = employee_table.getSelectionModel().getSelectedItem();
        int num = employee_table.getSelectionModel().getSelectedIndex();

        if((num-1) < -1) {
            return;
        }
         take_nameLabel.setText(employeeData.getName());
         take_dobLabel.setText(employeeData.getDob());
         take_phoneLabel.setText(employeeData.getPhone());
         take_emailLabel.setText(employeeData.getEmail());

        String uri = "file:" + employeeData.getImage();

        image = new Image(uri, 150, 197, false, true);
        profile_image.setImage(image);

    }

    public void loadEmployeeData() {
    // clear bảng
    employee_table.getItems().clear();
    showEmployee();

    }
    public void removeEmployee() {
    String sql = "DELETE FROM employee WHERE name = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        Alert alert;

        // Giả sử bạn chọn dòng trên bảng và lấy ID từ label hoặc field
        if (take_nameLabel.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Admin Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select an employee to remove.");
            alert.showAndWait();
        } else {
            // Xác nhận trước khi xóa
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this employee?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.isPresent() && option.get() == ButtonType.OK) {
                // Lấy ID từ label/field và đưa vào câu lệnh
                stmt.setString(1, take_nameLabel.getText());
                int affectedRows = stmt.executeUpdate();

                if (affectedRows > 0) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Admin Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee successfully removed.");
                    alert.showAndWait();

                    loadEmployeeData(); // gọi lại để cập nhật bảng
                    // TODO: Load lại bảng dữ liệu ở đây nếu cần
                } else {
                    alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Admin Message");
                    alert.setHeaderText(null);
                    alert.setContentText("No employee found with the given ID.");
                    alert.showAndWait();
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}






// SHOW STORAGE PAGE
    public void showStoragePage(ActionEvent event) {
    if (event.getSource() == books_table_button) {
        books_table_storage.setVisible(true);
        toys_table_storage.setVisible(false);
        stationaries_table_storage.setVisible(false);
    } 
    else if (event.getSource() == toys_table_button) {
        books_table_storage.setVisible(false);
        toys_table_storage.setVisible(true);
        stationaries_table_storage.setVisible(false);
    } 
    else if (event.getSource() == stationaries_table_button) {
        books_table_storage.setVisible(false);
        toys_table_storage.setVisible(false);
        stationaries_table_storage.setVisible(true);
    }
}





// SHOW BOOK TABLE
    public ObservableList<Book> bookDataList() {

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

    private ObservableList<Book> listBooks;
    public void showBook() {
    listBooks = bookDataList();

    bookId_storage_col.setCellValueFactory(new PropertyValueFactory<>("id"));
    bookIsbn_storage_col.setCellValueFactory(new PropertyValueFactory<>("isbn"));
    bookName_storage_col.setCellValueFactory(new PropertyValueFactory<>("name"));
    bookAuthor_storage_col.setCellValueFactory(new PropertyValueFactory<>("author"));
    bookPublisher_storage_col.setCellValueFactory(new PropertyValueFactory<>("publisher"));
    bookPurchasePrice_storage_col.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
    bookSellingPrice_storage_col.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
    bookQuantity_storage_col.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    books_table_storage.setItems(listBooks);
    // totalBook_label.setText("" + listBooks.size());
}


    public void loadBookData() {
    // clear bảng
    books_table_storage.getItems().clear();
    showBook();

    }


    public void removeSelectedItem() {
    Alert alert;

    try (Connection conn = DBConnection.getConnection()) {
        if (books_table_storage.isVisible() && books_table_storage.getSelectionModel().getSelectedItem() != null) {
            Book selectedBook = books_table_storage.getSelectionModel().getSelectedItem();
            String sql = "DELETE FROM book WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, selectedBook.getId());
                confirmAndDelete(stmt, "Book removed successfully");
                loadBookData();
            }
        } else if (toys_table_storage.isVisible() && toys_table_storage.getSelectionModel().getSelectedItem() != null) {
            Toy selectedToy = toys_table_storage.getSelectionModel().getSelectedItem();
            String sql = "DELETE FROM toy WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, selectedToy.getId());
                confirmAndDelete(stmt, "Toy removed successfully");
                loadToyData();
            }
        } else if (stationaries_table_storage.isVisible() && stationaries_table_storage.getSelectionModel().getSelectedItem() != null) {
            Stationery selectedStationary = stationaries_table_storage.getSelectionModel().getSelectedItem();
            String sql = "DELETE FROM stationery WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, selectedStationary.getId());
                confirmAndDelete(stmt, "Stationary removed successfully");
                loadStationeryData();
            }
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select an item to remove.");
            alert.showAndWait();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    private void confirmAndDelete(PreparedStatement stmt, String successMessage) throws SQLException {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirm Delete");
    alert.setHeaderText(null);
    alert.setContentText("Are you sure you want to delete this item?");
    Optional<ButtonType> option = alert.showAndWait();

    if (option.isPresent() && option.get() == ButtonType.OK) {
        int affectedRows = stmt.executeUpdate();
        Alert result = new Alert(Alert.AlertType.INFORMATION);
        result.setTitle("Result");
        result.setHeaderText(null);
        result.setContentText(affectedRows > 0 ? successMessage : "Item not found.");
        result.showAndWait();
    }
}








// SHOW TOY TABLE

private ObservableList<Toy> listToys;

public ObservableList<Toy> toyDataList() {
    ObservableList<Toy> listToys = FXCollections.observableArrayList();
    String sql = "SELECT * FROM toy";

    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet result = stmt.executeQuery(sql)) {

        Toy toy;
        while (result.next()) {
            toy = new Toy(
                result.getInt("id"),
                result.getString("name"),
                result.getInt("quantity"),
                result.getDouble("purchasePrice"),
                result.getDouble("sellingPrice"),
                result.getString("brand"),
                result.getString("suitableAges"),
                result.getString("toyType")
            );
            listToys.add(toy);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listToys;
}

public void showToy() {
    listToys = toyDataList();

    toyId_storage_col.setCellValueFactory(new PropertyValueFactory<>("id"));
    toyName_storage_col.setCellValueFactory(new PropertyValueFactory<>("name"));
    toyQuantity_storage_col.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    toyType_storage_col.setCellValueFactory(new PropertyValueFactory<>("toyType"));
    toyPurchasePrice_storage_col.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
    toySellingPrice_storage_col.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
    toyBrand_storage_col.setCellValueFactory(new PropertyValueFactory<>("brand"));
    toySuitableAge_storage_col.setCellValueFactory(new PropertyValueFactory<>("suitableAges"));
    // Nếu có toyType:
    // toyType_storage_col.setCellValueFactory(new PropertyValueFactory<>("toyType"));

    toys_table_storage.setItems(listToys);
}


public void loadToyData() {
    toys_table_storage.getItems().clear();
    showToy();
}








// SHOW STATIONERY TABLE
private ObservableList<Stationery> listStationeries;

public ObservableList<Stationery> stationeryDataList() {
    ObservableList<Stationery> listStationeries = FXCollections.observableArrayList();
    String sql = "SELECT * FROM stationery";

    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet result = stmt.executeQuery(sql)) {

        Stationery item;
        while (result.next()) {
            item = new Stationery(
                result.getInt("id"),
                result.getString("name"),
                result.getInt("quantity"),
                result.getDouble("purchasePrice"),
                result.getDouble("sellingPrice"),
                result.getString("brand"),
                result.getString("stationeryType")
            );
            listStationeries.add(item);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listStationeries;
}
public void showStationery() {
    listStationeries = stationeryDataList();

    stationeryId_storage_col.setCellValueFactory(new PropertyValueFactory<>("id"));
    stationeryName_storage_col.setCellValueFactory(new PropertyValueFactory<>("name"));
    stationeryQuantity_storage_col.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    stationeryPruchasePrice_storage_col.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
    stationerySeliingPrice_storage_col.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
    stationeryBrand_storage_col.setCellValueFactory(new PropertyValueFactory<>("brand"));
    stationeryType_storage_col.setCellValueFactory(new PropertyValueFactory<>("stationeryType"));

    stationaries_table_storage.setItems(listStationeries);
}

public void loadStationeryData() {
    stationaries_table_storage.getItems().clear();
    showStationery();
}




    private String comboBox[] = {"Book", "Stationery", "Toy"};

    public void TypeItem(){
        List<String> combo = new ArrayList<>();
        
        for (String data : comboBox) {
            combo.add(data);
        }

        ObservableList list = FXCollections.observableArrayList(combo);
        add_storage_button.setItems(list);
    }

    public void addStorage() {
        if (add_storage_button.getValue().equals("Book")) {
            books_add_storage.setVisible(true);
            stationery_add_storage.setVisible(false);
            toys_add_storage.setVisible(false);
            books_table_storage.setVisible(false);
            toys_table_storage.setVisible(false);
            stationaries_table_storage.setVisible(false);
            
        } else if (add_storage_button.getValue().equals("Stationery")) {
            books_add_storage.setVisible(false);
            stationery_add_storage.setVisible(true);
            toys_add_storage.setVisible(false);
            books_table_storage.setVisible(false);
            toys_table_storage.setVisible(false);
            stationaries_table_storage.setVisible(false);

        } else if (add_storage_button.getValue().equals("Toy")) {
            books_add_storage.setVisible(false);
            stationery_add_storage.setVisible(false);
            toys_add_storage.setVisible(true);
            books_table_storage.setVisible(false);
            toys_table_storage.setVisible(false);
            stationaries_table_storage.setVisible(false);
        }
    }


// LOGOUT
    @FXML
    public void logout(ActionEvent event) {
        try {
            if (event.getSource() == sign_out_button) {
                // TO SWAP FROM DASHBOARD TO LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("/view/fxml/Login_1.1.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

                sign_out_button.getScene().getWindow().hide();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // @override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        showEmployee();

        showBook();
        showToy();
        showStationery();
        TypeItem();
    }

}