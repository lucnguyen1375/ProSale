package ProSale.controller;

import ProSale.model.product.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    DecimalFormat df = new DecimalFormat("#,###");

    public void setData(Product product) {
        Image image = new Image(getClass().getResourceAsStream(product.getSrcImg()));
        imageView.setImage(image);
        labelName.setText(product.getName());
        labelPrice.setText(df.format(product.getPrice()) + "VND");
        labelQuantity.setText(String.valueOf(product.getQuantity()));
        labelTotalPrice.setText(df.format(product.getPrice() * product.getQuantity()) + "VND");
    }
}