package ProSale;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Demo extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Tạo ComboBox
        ComboBox<String> comboBox = new ComboBox<>();

        // Thêm dữ liệu vào ComboBox
        comboBox.getItems().addAll("Java", "Python", "C++", "JavaScript");

        // Đặt giá trị mặc định (tùy chọn)
        comboBox.setValue("Java");

        // Xử lý sự kiện khi chọn một mục
        comboBox.setOnAction(event -> {
            String selectedItem = comboBox.getValue();
            System.out.println("Bạn đã chọn: " + selectedItem);
        });

        // Tạo layout và thêm ComboBox vào
        VBox vbox = new VBox(comboBox);
        vbox.setSpacing(10);

        // Tạo Scene và hiển thị
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ComboBox Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
