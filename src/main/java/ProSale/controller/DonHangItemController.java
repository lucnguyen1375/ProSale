package ProSale.controller;

import ProSale.model.order.Order;
import ProSale.model.order.OrderItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DonHangItemController{

    @FXML
    private VBox vboxItem;
    @FXML
    private Label labelOrderStatus;

    public void setVboxItem(Order order) throws IOException {
        labelOrderStatus.setText(order.getOrderStatus());
        for(OrderItem orderItem : order.getOrderItemsList()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ProSale/FXML/OrderItem.fxml"));
            AnchorPane anchorPane = loader.load();
            OrderItemController controller = loader.getController();
            controller.setOrderItemData(orderItem);
            vboxItem.getChildren().add(anchorPane);
        }
    }

}
