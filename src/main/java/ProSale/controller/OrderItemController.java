package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.order.OrderItem;
import ProSale.model.product.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.text.DecimalFormat;

public class OrderItemController {
    @FXML
    ImageView imageView;
    @FXML
    AnchorPane ap;
    @FXML
    Label labelName, labelType, labelQuantity, labelPrice;


    private OrderItem orderItem;
    private Product product;
    public void setOrderItemData(OrderItem orderItem) {
        this.orderItem = orderItem;
        product = AppLaunch.server.getProductMap().get(orderItem.getProductID());
        Image image = new Image(getClass().getResourceAsStream(product.getSrcImg()));
        imageView.setImage(image);
        labelName.setText(product.getName());
        labelType.setText(product.getType());
        labelQuantity.setText("x" + String.valueOf(orderItem.getQuantity()));
        labelPrice.setText((new DecimalFormat("#, ###")).format(product.getPrice()) + " VND");
    }
}
