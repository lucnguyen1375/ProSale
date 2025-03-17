package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.order.OrderItem;
import ProSale.model.product.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.text.DecimalFormat;

public class MuaHangItemController {

    @FXML
    private Label labelPrice;

    @FXML
    private Label labelName;

    @FXML
    private Label labelQuantity;

    @FXML
    private Label labelTotal;
    @FXML
    private ImageView imageView;
    private VBox parentVBox;

    DecimalFormat df = new DecimalFormat("#,###");
    public void setData(VBox vbox, OrderItem orderItem) {
        this.parentVBox = vbox;
        Product product = AppLaunch.server.getProductMap().get(orderItem.getProductID());
        labelName.setText(product.getName());
        labelPrice.setText(df.format(product.getPrice()));
        labelQuantity.setText(String.valueOf(orderItem.getQuantity()));
        labelTotal.setText(df.format(product.getPrice() * orderItem.getQuantity()));
        Image image = new Image(getClass().getResourceAsStream(product.getSrcImg()));
        imageView.setImage(image);
    }

}
