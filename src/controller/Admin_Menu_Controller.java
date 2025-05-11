package controller;



import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
import model.Employee;



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


    private Connection connect;
    private PreparedStatement prepare;
    // private Statement statement;
    private ResultSet result;

    private Image image;

    public void showMenuPage(ActionEvent event) {
        if (event.getSource() == menu_button) {

            menu_page.setVisible(true);
            order_page.setVisible(false);
            // dashboard_page.setVisible(false);
            employee_page.setVisible(false);
            // storage_page.setVisible(false);

        }
         else if (event.getSource() == dashboard_button) {
            menu_page.setVisible(false);
            order_page.setVisible(false);
            // dashboard_page.setVisible(true);
            employee_page.setVisible(false);
            // storage_page.setVisible(false);
        }
        else if (event.getSource() == order_button) {
            menu_page.setVisible(false);
            order_page.setVisible(true);
            // dashboard_page.setVisible(false);
            employee_page.setVisible(false);
            // storage_page.setVisible(false);
        }
        else if (event.getSource() == employee_button) {
            menu_page.setVisible(false);
            order_page.setVisible(false);
            // dashboard_page.setVisible(false);
            employee_page.setVisible(true);
            // storage_page.setVisible(false);
        }
        else if (event.getSource() == storage_button) {
            menu_page.setVisible(false);
            order_page.setVisible(false);
            // dashboard_page.setVisible(false);
            employee_page.setVisible(false);
            // storage_page.setVisible(true);
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
    }

}