package controller;


import java.net.URL;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Function;

import javax.swing.Action;

import javafx.scene.control.*;
import dao.BookDAO;

import dao.EmployeeDAO;
import dao.ToyDAO;
import dao.StationeryDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
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


    @FXML
    private VBox order_page;

    @FXML
    private VBox dashboard_page;


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

    @FXML
    private StackPane storage_add;

    @FXML
    private Button stationary_close_button;

    @FXML
    private Button book_close_button;  

    @FXML
    private Button toy_close_button;

    @FXML
    private HBox function_under_storage;

    @FXML
    private VBox storage_table_view;

    @FXML
    private VBox setting_page;

    private Image image;




    @FXML
    private Region bar10;
    @FXML
    private Region bar20;
    // Add others as needed

    @FXML
    public void initialize() {
        setProgress(bar10, 1);
        setProgress(bar20, 0.20);
        // ...
    }

    private void setProgress(Region bar, double percentage) {
        bar.setPrefWidth(160 * percentage); // 300 is full width
    }


   
    @FXML
    private Button setting_button;
    // SHOW MENU PAGE
    public void showMenuPage(ActionEvent event) {

       
        if (event.getSource() == dashboard_button) {
  
            order_page.setVisible(false);
            dashboard_page.setVisible(true);
            employee_page.setVisible(false);
            storage_page.setVisible(false);
            setting_page.setVisible(false);
        }
        else if (event.getSource() == order_button) {
 
            order_page.setVisible(true);
            dashboard_page.setVisible(false);
            employee_page.setVisible(false);
            storage_page.setVisible(false);
            setting_page.setVisible(false);
        }
        else if (event.getSource() == employee_button) {
            
            order_page.setVisible(false);
            dashboard_page.setVisible(false);
            employee_page.setVisible(true);
            storage_page.setVisible(false);
            setting_page.setVisible(false);
        }
        else if (event.getSource() == storage_button) {
            
            order_page.setVisible(false);
            dashboard_page.setVisible(false);
            employee_page.setVisible(false);
            storage_page.setVisible(true);
            setting_page.setVisible(false);
        }
        else if (event.getSource() == dashboard_button) {
           
            order_page.setVisible(false);
            dashboard_page.setVisible(true);
            employee_page.setVisible(false);
            storage_page.setVisible(false);
            setting_page.setVisible(false);
        }
        else if (event.getSource() == setting_button) {
          
            order_page.setVisible(false);
            dashboard_page.setVisible(false);
            employee_page.setVisible(false);
            storage_page.setVisible(false);
            setting_page.setVisible(true);
        }
    }




    private ObservableList<Employee> listEmployees;

    @FXML
    public void showEmployee() {

        listEmployees = EmployeeDAO.getEmployeeDataList();

        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        dob_col.setCellValueFactory(new PropertyValueFactory<>("dob"));
        address_col.setCellValueFactory(new PropertyValueFactory<>("address"));
        salary_col.setCellValueFactory(new PropertyValueFactory<>("salary"));
        employee_table.setItems(listEmployees);

        totalEmployee_label.setText(""+listEmployees.size());
        //totalEmployee_label_menu.setText(""+listEmployees.size());
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

    public Label getTake_nameLabel() {
    return take_nameLabel;
}

   
    @FXML
    public void removeEmployee(ActionEvent event) {
        if (event.getSource() == e_remove) {
            try {
                // Gọi DAO chỉ xử lý SQL
                boolean removed = EmployeeDAO.removeEmployee(this);

                // Hiển thị thông báo tương ứng
                Alert alert;
                if (removed) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Admin Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee successfully removed.");
                    alert.showAndWait();

                    showEmployee(); // Refresh bảng nếu cần
                } else {
                    alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Admin Message");
                    alert.setHeaderText(null);
                    alert.setContentText("No employee found with the given name.");
                    alert.showAndWait();
                }
            } catch (IllegalArgumentException e) {
                // Trường hợp label chưa chọn hoặc null
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Error");
                alert.setHeaderText(null);
                alert.setContentText("An unexpected error occurred.");
                alert.showAndWait();
            }
        }
    }



    // SHOW ADD EMPLOYEE PAGE
    @FXML
    private VBox employee_add_page;

    @FXML
    private VBox employee_table_page;

    @FXML
    private Button confirm_add_employee_btn;

    @FXML
    private Button close_addwindow_employee_btn;

    public void showAddEmployeePage(ActionEvent event) {
    if (event.getSource() == e_add) {
        employee_table_page.setVisible(false);
        employee_add_page.setVisible(true);
    }
        
}



    @FXML
    private TextField add_employee_name;
    @FXML
    private TextField add_employee_dob;
    @FXML
    private TextField add_employee_address;
    @FXML
    private TextField add_employee_salary;
    @FXML
    private TextField add_employee_number;
    @FXML
    private TextField add_employee_email;
    @FXML
    private TextField add_employee_image;
    @FXML
    private TextField add_employee_id;

    public TextField getAdd_employee_id() { return add_employee_id; }
    public TextField getAdd_employee_name() { return add_employee_name; }
    public TextField getAdd_employee_dob() { return add_employee_dob; }
    public TextField getAdd_employee_address() { return add_employee_address; }
    public TextField getAdd_employee_salary() { return add_employee_salary; }
    public TextField getAdd_employee_number() { return add_employee_number; }
    public TextField getAdd_employee_email() { return add_employee_email; }
    public int getSelectedEmployeeId() {
    Employee selectedEmployee = employee_table.getSelectionModel().getSelectedItem();

    if (selectedEmployee == null) {
        throw new IllegalArgumentException("Please select an employee from the table.");
    }

    return selectedEmployee.getId();
}




    public void addNewEmployee(ActionEvent event) {
    if (event.getSource() == confirm_add_employee_btn) {
        try {
            boolean success = EmployeeDAO.addEmployee(this);

            Alert alert;
            if (success) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully added new employee!");
                alert.showAndWait();

                clearEmployeeData(); // Xóa form
                showEmployee();      // Refresh bảng
            } else {
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Employee was not added.");
                alert.showAndWait();
            }

        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("System Error");
            alert.setHeaderText(null);
            alert.setContentText("An unexpected error occurred while adding the employee.");
            alert.showAndWait();
        }
    }
}



    public void clearEmployeeData() {
       
        add_employee_name.clear();
        add_employee_dob.clear();
        add_employee_address.clear();
        add_employee_salary.clear();
        add_employee_number.clear();
        add_employee_email.clear();
        profile_image.setImage(null);
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


    private ObservableList<Book> listBooks;
    public void showBook() {
    listBooks = BookDAO.bookDataList();

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


    // ADD BOOK
    @FXML
    private TextField add_book_id;
    @FXML
    private TextField add_book_name;
    @FXML
    private TextField add_book_quantity;
    @FXML
    private TextField add_book_purchase_price;
    @FXML
    private TextField add_book_selling_price;
    @FXML
    private TextField add_book_author;
    @FXML
    private TextField add_book_publisher;
    @FXML
    private TextField add_book_isbn;
    @FXML
    private TextField add_book_genre;
    @FXML
    private Button add_book_button;


    private void clearBookFields() {
    add_book_id.clear();
    add_book_name.clear();
    add_book_quantity.clear();
    add_book_purchase_price.clear();
    add_book_selling_price.clear();
    add_book_publisher.clear();
    add_book_author.clear();
    add_book_isbn.clear();
    add_book_genre.clear();
}



    public TextField getAdd_book_id() { return add_book_id; }
    public TextField getAdd_book_name() { return add_book_name; }
    public TextField getAdd_book_quantity() { return add_book_quantity; }
    public TextField getAdd_book_purchase_price() { return add_book_purchase_price; }
    public TextField getAdd_book_selling_price() { return add_book_selling_price; }
    public TextField getAdd_book_publisher() { return add_book_publisher; }
    public TextField getAdd_book_author() { return add_book_author; }
    public TextField getAdd_book_isbn() { return add_book_isbn; }
    public TextField getAdd_book_genre() { return add_book_genre; }

    @FXML
    public void addNewBook(ActionEvent event) {
    if (event.getSource() == add_book_button) {
        try {
            // Gọi DAO để thêm sách, nếu lỗi input sẽ ném ra
            boolean success = BookDAO.addNewBook(this);

            Alert alert;
            if (success) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully added new book!");
                alert.showAndWait();

                clearBookFields();  // Xóa form
                loadBookData();     // Refresh bảng
            } else {
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Book was not added.");
                alert.showAndWait();
            }

        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("System Error");
            alert.setHeaderText(null);
            alert.setContentText("An unexpected error occurred while adding the book.");
            alert.showAndWait();
        }
    }
}


    public void loadBookData() {
    // clear bảng
    books_table_storage.getItems().clear();
    showBook();

    }


    private void handleRemoveWithQuantity(
        String itemType,
        String itemName,
        int currentQty,
        Function<Integer, Boolean> deleteFunction,
        Runnable reloadFunction
) {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Xoá " + itemType);
    dialog.setHeaderText("Tên: " + itemName + "\nSố lượng hiện có: " + currentQty);
    dialog.setContentText("Nhập số lượng muốn xoá:");

    Optional<String> result = dialog.showAndWait();

    result.ifPresent(input -> {
        try {
            int qtyToRemove = Integer.parseInt(input);

            if (qtyToRemove <= 0) {
                showError("Vui lòng nhập số lượng > 0.");
                return;
            }

            if (qtyToRemove > currentQty) {
                showError("Số lượng xoá lớn hơn số lượng hiện có.");
                return;
            }

            if (confirmDelete("Bạn có chắc muốn xoá " + qtyToRemove + " " + itemType + " này?")) {
                boolean success = deleteFunction.apply(qtyToRemove);
                if (success) {
                    showInfo("Xoá " + itemType + " thành công.");
                    reloadFunction.run();
                } else {
                    showError("Xoá " + itemType + " thất bại.");
                }
            }

        } catch (NumberFormatException e) {
            showError("Vui lòng nhập số hợp lệ.");
        }
    });
}



    public void removeSelectedItem() {
    if (books_table_storage.isVisible() && books_table_storage.getSelectionModel().getSelectedItem() != null) {
        Book selectedBook = books_table_storage.getSelectionModel().getSelectedItem();
        handleRemoveWithQuantity(
            "sách",
            selectedBook.getName(),
            selectedBook.getQuantity(),
            qty -> BookDAO.deleteBookById(selectedBook.getId(), qty),
            this::loadBookData
        );

    } else if (toys_table_storage.isVisible() && toys_table_storage.getSelectionModel().getSelectedItem() != null) {
        Toy selectedToy = toys_table_storage.getSelectionModel().getSelectedItem();
        handleRemoveWithQuantity(
            "đồ chơi",
            selectedToy.getName(),
            selectedToy.getQuantity(),
            qty -> ToyDAO.deleteToyById(selectedToy.getId(), qty),
            this::loadToyData
        );

    } else if (stationaries_table_storage.isVisible() && stationaries_table_storage.getSelectionModel().getSelectedItem() != null) {
        Stationery selectedStationery = stationaries_table_storage.getSelectionModel().getSelectedItem();
        handleRemoveWithQuantity(
            "văn phòng phẩm",
            selectedStationery.getName(),
            selectedStationery.getQuantity(),
            qty -> StationeryDAO.deleteStationeryById(selectedStationery.getId(), qty),
            this::loadStationeryData
        );

    } else {
        showError("Vui lòng chọn mục cần xoá.");
    }
}



    // public void removeSelectedItem() {
    //     // Alert alert;

    //     try {
    //         if (books_table_storage.isVisible() && books_table_storage.getSelectionModel().getSelectedItem() != null) {
    //             Book selectedBook = books_table_storage.getSelectionModel().getSelectedItem();

    //             if (confirmDelete("Bạn có chắc muốn xoá sách này?")) {
    //                 BookDAO.deleteBookById(selectedBook.getId());
    //                 showInfo("Book removed successfully");
    //                 loadBookData();
    //             }

    //         } else if (toys_table_storage.isVisible() && toys_table_storage.getSelectionModel().getSelectedItem() != null) {
    //             Toy selectedToy = toys_table_storage.getSelectionModel().getSelectedItem();

    //             if (confirmDelete("Bạn có chắc muốn xoá đồ chơi này?")) {
    //                 ToyDAO.deleteToyById(selectedToy.getId());
    //                 showInfo("Toy removed successfully");
    //                 loadToyData();
    //             }

    //         } else if (stationaries_table_storage.isVisible() && stationaries_table_storage.getSelectionModel().getSelectedItem() != null) {
    //             Stationery selectedStationery = stationaries_table_storage.getSelectionModel().getSelectedItem();

    //             if (confirmDelete("Bạn có chắc muốn xoá văn phòng phẩm này?")) {
    //                 StationeryDAO.deleteStationeryById(selectedStationery.getId());
    //                 showInfo("Stationery removed successfully");
    //                 loadStationeryData();
    //             }

    //         } else {
    //             showError("Please select an item to remove.");
    //         }

    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         showError("Lỗi khi xoá dữ liệu.");
    //     }
    // }

    private boolean confirmDelete(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận xoá");
        alert.setHeaderText(null);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Lỗi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }












    // SHOW TOY TABLE

    private ObservableList<Toy> listToys;

    public void showToy() {
        listToys = ToyDAO.toyDataList();

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

//ADD TOY  
    @FXML
    private TextField add_toy_id;
    @FXML
    private TextField add_toy_name; 
    @FXML
    private TextField add_toy_quantity;
    @FXML
    private TextField add_toy_purchase_price;
    @FXML
    private TextField add_toy_selling_price;
    @FXML
    private TextField add_toy_brand;
    @FXML
    private TextField add_toy_suitable_age;
    @FXML
    private TextField add_toy_type;
    @FXML
    private TextField add_toy_image;
    @FXML 
    private Button add_toy_button;


public void clearToyData() {
       
        add_toy_id.clear();
        add_toy_name.clear();
        add_toy_quantity.clear();
        add_toy_purchase_price.clear();
        add_toy_selling_price.clear();
        add_toy_brand.clear();
        add_toy_suitable_age.clear();
        add_toy_type.clear();
    }
    


    public TextField getAdd_toy_id() { return add_toy_id; }
    public TextField getAdd_toy_name() { return add_toy_name; }
    public TextField getAdd_toy_quantity() { return add_toy_quantity; }
    public TextField getAdd_toy_purchase_price() { return add_toy_purchase_price; }
    public TextField getAdd_toy_selling_price() { return add_toy_selling_price; }
    public TextField getAdd_toy_brand() { return add_toy_brand; }
    public TextField getAdd_toy_suitable_age() { return add_toy_suitable_age; }
    public TextField getAdd_toy_type() { return add_toy_type; }

    @FXML
    public void addNewToy(ActionEvent event) {
    if (event.getSource() == add_toy_button) { // Đảm bảo `toy_add_button` đúng tên biến nút
        try {
            // boolean success = ToyDAO.addToy(this);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Admin Message");
            alert.setHeaderText(null);
            alert.setContentText("Thêm đồ chơi thành công!");
            alert.showAndWait();

            clearToyData(); // reset form
            showToy();      // cập nhật bảng

        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi dữ liệu");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi hệ thống");
            alert.setHeaderText(null);
            alert.setContentText("Đã xảy ra lỗi trong quá trình thêm đồ chơi.");
            alert.showAndWait();
        }
    }
}


    @FXML
    private Button employee_pay_button;

    @FXML
    private VBox employees_payment_table_page;

    public void showPaymentPage(ActionEvent event) {
        if (event.getSource() == employee_pay_button) {
            
            employee_table_page.setVisible(false);
            employees_payment_table_page.setVisible(true);
        }
    }




// ADD STATIONERY
    @FXML
    private TextField add_stationery_id;
    @FXML
    private TextField add_stationery_name;
    @FXML
    private TextField add_stationery_quantity;
    @FXML
    private TextField add_stationery_purchase_price;
    @FXML
    private TextField add_stationery_selling_price;
    @FXML
    private TextField add_stationery_brand;
    @FXML
    private TextField add_stationery_type;
    @FXML
    private Button add_stationary_button;

    private void clearStationeryFields() {
        add_stationery_id.clear();
        add_stationery_name.clear();
        add_stationery_quantity.clear();
        add_stationery_purchase_price.clear();
        add_stationery_selling_price.clear();
        add_stationery_brand.clear();
        add_stationery_type.clear();
    }


    public TextField getAdd_stationery_id() { return add_stationery_id; }
    public TextField getAdd_stationery_name() { return add_stationery_name; }
    public TextField getAdd_stationery_quantity() { return add_stationery_quantity; }
    public TextField getAdd_stationery_purchase_price() { return add_stationery_purchase_price; }
    public TextField getAdd_stationery_selling_price() { return add_stationery_selling_price; }
    public TextField getAdd_stationery_brand() { return add_stationery_brand; }
    public TextField getAdd_stationery_type() { return add_stationery_type; }


    @FXML
    public void addNewStationery(ActionEvent event) {
    if (event.getSource() == add_stationary_button) { // Đảm bảo đúng tên biến button
        try {
            // boolean success = StationeryDAO.addStationery(this);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Thêm văn phòng phẩm thành công!");
            alert.showAndWait();

            clearStationeryFields(); // reset form
            showStationery();        // load lại bảng

        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi dữ liệu");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi hệ thống");
            alert.setHeaderText(null);
            alert.setContentText("Đã xảy ra lỗi khi thêm văn phòng phẩm.");
            alert.showAndWait();
        }
    }
}





    // SHOW STATIONERY TABLE
    private ObservableList<Stationery> listStationeries;


    public void showStationery() {
    listStationeries = StationeryDAO.stationeryDataList();

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
            add_storage_button.setPromptText("Add...");
        }
        







    // Open Add Window
    public void addStorage() {
        if (add_storage_button.getValue().equals("Book")) {
            books_add_storage.setVisible(true);
            stationery_add_storage.setVisible(false);
            toys_add_storage.setVisible(false);

            storage_table_view.setVisible(false);
            storage_add.setVisible(true);
            function_under_storage.setVisible(false);
            
        } else if (add_storage_button.getValue().equals("Stationery")) {
            books_add_storage.setVisible(false);
            stationery_add_storage.setVisible(true);
            toys_add_storage.setVisible(false);
          
            storage_table_view.setVisible(false);
            storage_add.setVisible(true);
            function_under_storage.setVisible(false);

        } else if (add_storage_button.getValue().equals("Toy")) {
            books_add_storage.setVisible(false);
            stationery_add_storage.setVisible(false);
            toys_add_storage.setVisible(true);
           
            storage_table_view.setVisible(false);
            storage_add.setVisible(true);
            function_under_storage.setVisible(false);
        }
    }


    public void closeAddWindow(ActionEvent event) {
    if (event.getSource() == stationary_close_button) {
            

            books_table_storage.setVisible(false);
            toys_table_storage.setVisible(false);
            stationaries_table_storage.setVisible(true);
            storage_add.setVisible(false);
            function_under_storage.setVisible(true);
            storage_table_view.setVisible(true);

    } else if (event.getSource() == book_close_button) {
         
            books_table_storage.setVisible(true);
            toys_table_storage.setVisible(false);
            stationaries_table_storage.setVisible(false);
            storage_add.setVisible(false);
            function_under_storage.setVisible(true);
            storage_table_view.setVisible(true);

    } else if (event.getSource() == toy_close_button) {
          
            books_table_storage.setVisible(false);
            toys_table_storage.setVisible(true);
            stationaries_table_storage.setVisible(false);
            storage_add.setVisible(false);
            function_under_storage.setVisible(true);
            storage_table_view.setVisible(true);
            
    } else if (event.getSource() == close_addwindow_employee_btn) {
            employee_table_page.setVisible(true);
            employee_add_page.setVisible(false);
        }
        add_storage_button.setValue(null);
       
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