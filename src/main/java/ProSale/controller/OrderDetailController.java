package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.manager.IOSystem;
import ProSale.model.order.Order;
import ProSale.model.order.OrderItem;
import ProSale.model.person.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;


public class OrderDetailController implements Initializable {
    @FXML
    private Label labelOrderAddress, labelOrderDate, labelOrderID
            , labelPhone, labelTenNguoiNhan, labelUserName, labelOrderStatus
            , labelOrderThanhToan, labelOrderTotal;
    @FXML
    private VBox vboxOrderItem;

    @FXML
    private Button btnTroVe, btnUpdate, btnLuu;
    @FXML
    private Scene preScene;
    @FXML
    private HBox hboxOrderState, hboxUpdateOrder;
    @FXML
    ComboBox<String> comboBoxOrderStatus, comboBoxOrderThanhToan;

    private Order order;

    public void setVboxOrderItem(Order order) throws Exception {
        for(OrderItem orderItem : order.getOrderItemsList()){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AppLaunch.class.getResource("/ProSale/FXML/OrderItem.fxml"));
            AnchorPane pane = loader.load();
            OrderItemController controller = loader.getController();
            controller.setOrderItemData(orderItem);
            vboxOrderItem.getChildren().add(pane);
        }

    }

    public void setData(Order order) throws Exception {
        this.order = order;
        labelOrderID.setText(String.valueOf(order.getOrderID()));
        labelOrderDate.setText(String.valueOf(order.getOrderDate()));
        labelOrderAddress.setText(order.getOrderAddress());
        labelPhone.setText(order.getOrderPhone());
        labelTenNguoiNhan.setText(order.getOrderTenNguoiNhan());
        labelUserName.setText(AppLaunch.server.getPersonMap().get(order.getCustomerID()).getName());
        labelOrderStatus.setText(order.getOrderStatus());
        labelOrderThanhToan.setText(order.getOrderThanhToan());
        int total = 0;
        for(OrderItem orderItem : order.getOrderItemsList()){
            total += AppLaunch.server.getProductMap().get(orderItem.getProductID()).getPrice() * orderItem.getQuantity();
        }
        labelOrderTotal.setText(new DecimalFormat("#,###").format(total) + " VND");
        setVboxOrderItem(order);
    }

    public void setPreScene(Scene preScene){
        this.preScene = preScene;
    }

    public void btnTroVeOnAction(ActionEvent event) {
        Stage stage = (Stage) btnTroVe.getScene().getWindow();
        stage.setScene(preScene);
    }

    public void btnUpdateOnAction(ActionEvent event) {
        comboBoxOrderThanhToan.setValue(order.getOrderThanhToan());
        comboBoxOrderStatus.setValue(order.getOrderStatus());
        hboxOrderState.setVisible(false);
        hboxUpdateOrder.setVisible(true);
    }

    public void btnLuuOnAction(ActionEvent event) throws Exception {
        order.setOrderStatus(comboBoxOrderStatus.getValue());
        order.setOrderThanhToan(comboBoxOrderThanhToan.getValue());
        labelOrderStatus.setText(order.getOrderStatus());
        labelOrderThanhToan.setText(order.getOrderThanhToan());
        hboxOrderState.setVisible(true);
        hboxUpdateOrder.setVisible(false);
        IOSystem.saveData();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (AppLaunch.server.getPersonUsing() instanceof Admin){
            btnUpdate.setVisible(true);
        } else btnUpdate.setVisible(false);

        hboxOrderState.setVisible(true);
        hboxUpdateOrder.setVisible(false);

        System.out.println(comboBoxOrderStatus);
    }
}
