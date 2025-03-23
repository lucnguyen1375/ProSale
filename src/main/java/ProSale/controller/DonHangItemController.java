package ProSale.controller;

import ProSale.model.order.Order;
import ProSale.model.order.OrderItem;
import ProSale.model.product.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DonHangItemController implements Initializable {

    @FXML
    private VBox vboxItem;
    @FXML
    private Label labelOrderStatus, labelThanhToan;

    private Order order;
    private MyListener myListener;

    @FXML
    private void click(MouseEvent event) {
        myListener.onClickListenerOrder(order);
    }
    public void setVboxItem(Order order) throws IOException {
        labelOrderStatus.setText(order.getOrderStatus());
        labelThanhToan.setText(order.getOrderThanhToan());
        this.order = order;
        for(OrderItem orderItem : order.getOrderItemsList()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ProSale/FXML/OrderItem.fxml"));
            AnchorPane anchorPane = loader.load();
            OrderItemController controller = loader.getController();
            controller.setOrderItemData(orderItem);
            vboxItem.getChildren().add(anchorPane);
        }
    }

    public void setMyListener(MyListener myListener) {
        this.myListener = myListener;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListener = new MyListener() {
            @Override
            public void onClickListenerProduct(Product product) {}
            @Override
            public void onClickListenerOrder(Order order) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    Stage stage = (Stage) vboxItem.getScene().getWindow();
                    loader.setLocation(getClass().getResource("/ProSale/FXML/OrderDetail.fxml"));
                    Parent parent = loader.load();
                    Scene scene = new Scene(parent);
                    OrderDetailController controller = loader.getController();
                    controller.setData(order);
                    controller.setPreScene(vboxItem.getScene());
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
