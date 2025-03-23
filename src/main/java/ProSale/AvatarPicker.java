package ProSale;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class AvatarPicker extends Application {
    private static final String RESOURCE_PATH = "src/main/resources/ProSale/images/product/"; // Đường dẫn thư mục lưu ảnh
    private ImageView imageView;

    @Override
    public void start(Stage primaryStage) {
        Button btnSelectImage = new Button("Chọn ảnh đại diện");
        imageView = new ImageView();
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);

        btnSelectImage.setOnAction(e -> chooseImage(primaryStage));

        VBox root = new VBox(10, btnSelectImage, imageView);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chọn Ảnh Đại Diện");
        primaryStage.show();
    }

    private void chooseImage(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Hình ảnh", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            try {
                // Đọc ảnh và lưu vào thư mục resources
                File savedFile = saveImageToResources(selectedFile);

                // Hiển thị ảnh trong ImageView
                InputStream imageStream = new FileInputStream(savedFile);
                Image image = new Image(imageStream);
                imageView.setImage(image);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private File saveImageToResources(File sourceFile) throws Exception {
        File directory = new File(RESOURCE_PATH);
        if (!directory.exists()) {
            directory.mkdirs(); // Tạo thư mục nếu chưa tồn tại
        }

        String newFileName = "1.png"; // Đặt tên file mới
        File destinationFile = new File(RESOURCE_PATH + newFileName);

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }

        return destinationFile;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
