package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.order.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminDonHangController implements Initializable {
    @FXML
    Button btnTatCa, btnChoXacNhan, btnChuaVanChuyen, btnDaVanChuyen, btnChuaThanhToan, btnDaThanhToan;
    @FXML
    VBox vboxAdminDonHang;

    public void setVboxAdminDonHang(List<Order> listOrder) throws Exception {
        for(Order order : listOrder){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DonHangController.class.getResource("/ProSale/FXML/DonHangItem.fxml"));
            AnchorPane pane = loader.load();
            DonHangItemController controller = loader.getController();
            controller.setVboxItem(order);
            vboxAdminDonHang.getChildren().add(pane);
        }
    }
    public void btnTatCaOnAction(ActionEvent actionEvent) {
        System.out.println("Tat ca san pham");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setVboxAdminDonHang(AppLaunch.server.getOrderList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
