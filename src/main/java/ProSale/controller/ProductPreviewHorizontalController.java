package ProSale.controller;

import ProSale.model.product.Product;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;


public class ProductPreviewHorizontalController {
    @FXML
    private ImageView imgProduct;

    @FXML
    private Label labelProductName;

    @FXML
    private Label labelProductPrice;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label labelQuantity;

    @FXML
    private Stage stage;

    private MyListener myListener;
    private Product product;

    @FXML
    private void click(MouseEvent event) {
        myListener.onClickListenerProduct(product);
    }

    public void setData(Product product, MyListener myListener) {
        this.product = product;
        this.myListener = myListener;
        labelProductName.setText(product.getName());
        labelQuantity.setText(String.valueOf(product.getQuantity()));
        labelProductPrice.setText(new DecimalFormat("#,###").format(product.getPrice()) + " VND");
        Image image = new Image(getClass().getResourceAsStream(product.getSrcImg()));
        imgProduct.setImage(image);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
