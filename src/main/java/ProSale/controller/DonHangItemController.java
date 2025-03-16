package ProSale.controller;

import ProSale.model.order.Order;
import ProSale.model.order.OrderItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class DonHangItemController {

    @FXML
    private VBox vboxItem;

    public void setVboxItem(Order order) throws Exception {
        for(OrderItem orderItem : order.getOrderItemsList()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/OrderItem.fxml"));
            AnchorPane pane = loader.load();
            vboxItem.getChildren().add(pane);
        }
    }
}
