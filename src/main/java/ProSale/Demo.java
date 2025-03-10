package ProSale;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Demo extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox(10);  // VBox với khoảng cách 10px giữa các hàng

        // Tạo các Stage động và thêm vào VBox
        for (int i = 1; i <= 5; i++) {
            Stage stage = new Stage();  // Giả sử mỗi hàng đại diện cho một Stage khác nhau
            stage.setTitle("Stage " + i);

            // Tạo HBox cho mỗi hàng
            HBox hbox = new HBox(10);
            Label label = new Label("Stage " + i);
            Button deleteButton = new Button("Delete");

            // Sự kiện bấm nút Delete để xóa hàng tương ứng
            deleteButton.setOnAction(e -> {
                vbox.getChildren().remove(hbox);
                System.out.println("Đã xóa: " + label.getText());
                stage.close();  // Đóng Stage tương ứng (nếu cần)
            });

            hbox.getChildren().addAll(label, deleteButton);
            vbox.getChildren().add(hbox);
        }

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Xóa hàng động trong VBox");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}