package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.order.Order;
import ProSale.model.order.OrderItem;
import ProSale.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminDonHangController implements Initializable {
    @FXML
    Button btnTatCa, btnChoXacNhan, btnDangChuanBi, btDangVanChuyen, btnDaVanChuyen, btnChuaThanhToan, btnDaThanhToan;
    @FXML
    VBox vboxAdminDonHang;
    @FXML
    private Button btnBack;

    List<Order> orderList;

    MyListener myListener;
    public void setVboxAdminDonHang(List<Order> listOrder) throws Exception {
        vboxAdminDonHang.getChildren().clear();
        for(Order order : listOrder){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ProSale/FXML/DonHangItem.fxml"));
            AnchorPane pane = loader.load();
            DonHangItemController controller = loader.getController();
            controller.setVboxItem(order);
            controller.setMyListener(myListener);
            vboxAdminDonHang.getChildren().add(pane);
        }
    }

    public void btnTatCaOnAction(ActionEvent actionEvent) throws Exception {
        orderList = new ArrayList<>(AppLaunch.server.getOrderList());
        setVboxAdminDonHang(orderList);
    }

    public void btnXacNhanOnAction(ActionEvent actionEvent) throws Exception {
        orderList = new ArrayList<>();
        for(Order order : AppLaunch.server.getOrderList()){
            if (order.getOrderStatus().equals(((Button)actionEvent.getSource()).getText())){
                orderList.add(order);
            }
        }
        setVboxAdminDonHang(orderList);
    }

    public void btnThanhToanOnAction(ActionEvent actionEvent) throws Exception {
        orderList = new ArrayList<>();
        for(Order order : AppLaunch.server.getOrderList()){
            if (order.getOrderThanhToan().equals(((Button)actionEvent.getSource()).getText())){
                orderList.add(order);
            }
        }
        setVboxAdminDonHang(orderList);
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) vboxAdminDonHang.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/MainView.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListener = new MyListener() {
            @Override
            public void onClickListenerProduct(Product product) {}
            @Override
            public void onClickListenerOrder(Order order) {
                try {
                    System.out.println("onClickListenerOrder");
//                    for(OrderItem orderItem : order.getOrderItemsList())
//                    {
//                        System.out.println(order);
//                    }
                    FXMLLoader loader = new FXMLLoader();
                    Stage stage = (Stage) vboxAdminDonHang.getScene().getWindow();
                    loader.setLocation(getClass().getResource("/ProSale/FXML/OrderDetail.fxml"));
                    Parent parent = loader.load();
                    Scene scene = new Scene(parent);
                    OrderDetailController controller = loader.getController();
                    controller.setData(order);
                    controller.setPreScene(vboxAdminDonHang.getScene());
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        try {
//            setVboxAdminDonHang(AppLaunch.server.getOrderList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
