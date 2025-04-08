import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Form Đăng Ký Người Dùng");

        // Tạo menu
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem menuExit = new MenuItem("Thoát");
        menuExit.setOnAction(e -> primaryStage.close());
        menuFile.getItems().add(menuExit);
        menuBar.getMenus().add(menuFile);

        // Form nhập liệu
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setVgap(10);
        grid.setHgap(10);

        Label nameLabel = new Label("Họ và tên:");
        TextField nameField = new TextField();

        Label genderLabel = new Label("Giới tính:");
        ComboBox<String> genderCombo = new ComboBox<>();
        genderCombo.getItems().addAll("Nam", "Nữ", "Khác");
        genderCombo.setValue("Nam");

        Label ageLabel = new Label("Tuổi:");
        Spinner<Integer> ageSpinner = new Spinner<>(1, 100, 18);

        Button submitBtn = new Button("Gửi");
        submitBtn.setOnAction(e -> {
            String name = nameField.getText();
            String gender = genderCombo.getValue();
            int age = ageSpinner.getValue();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông tin người dùng");
            alert.setHeaderText("Dữ liệu đã nhập:");
            alert.setContentText("Họ tên: " + name + "\nGiới tính: " + gender + "\nTuổi: " + age);
            alert.showAndWait();
        });

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(genderLabel, 0, 1);
        grid.add(genderCombo, 1, 1);
        grid.add(ageLabel, 0, 2);
        grid.add(ageSpinner, 1, 2);
        grid.add(submitBtn, 1, 3);

        VBox layout = new VBox(menuBar, grid);

        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
