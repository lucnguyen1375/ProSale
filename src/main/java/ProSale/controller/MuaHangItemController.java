package ProSale.controller;

import ProSale.model.order.OrderItem;
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
        labelName.setText(orderItem.getProduct().getName());
        labelPrice.setText(df.format(orderItem.getProduct().getPrice()));
        labelQuantity.setText(String.valueOf(orderItem.getQuantity()));
        labelTotal.setText(df.format(orderItem.getProduct().getPrice()*orderItem.getQuantity()));
        Image image = new Image(getClass().getResourceAsStream(orderItem.getProduct().getSrcImg()));
        imageView.setImage(image);
    }

}
