package ProSale.controller;

import ProSale.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class GioHangItemController {

    @FXML
    private Button btnDelete;

    @FXML
    private CheckBox checkBox;

    @FXML
    private ImageView imageView;

    @FXML
    private Label labelName;

    @FXML
    private Label labelPrice;

    @FXML
    private Label labelQuantity;

    @FXML
    private Label labelTotalPrice;

    private VBox parentVBox;  // Tham chiếu đến VBox cha
    private AnchorPane pane;     // Tham chiếu đến chính hàng này

    // Hàm này được gọi từ MainApp để khởi tạo các tham chiếu
    public void initData(VBox parentVBox, AnchorPane pane) {
        this.parentVBox = parentVBox;
        this.pane = pane;
    }
    private Product product;
    public void setData(Product product) {
        this.product = product;
        Image image = new Image(getClass().getResourceAsStream(product.getSrcImg()));
        imageView.setImage(image);
        labelName.setText(product.getName());
        labelPrice.setText(new DecimalFormat("#,###").format(product.getPrice()) + " VND");
        labelQuantity.setText(String.valueOf(product.getQuantity()));
        labelTotalPrice.setText(new DecimalFormat("#,###").format(product.getPrice() * product.getQuantity()) + " VND");
    }

    public void delete(ActionEvent actionEvent) {
        parentVBox.getChildren().remove(pane);
        System.out.println("Đã xóa" + product.getName());
    }
}