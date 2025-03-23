package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.manager.IOSystem;
import ProSale.model.order.GioHang;
import ProSale.model.order.Order;
import ProSale.model.order.OrderItem;
import ProSale.model.person.User;
import ProSale.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class MuaHangController implements Initializable {
    @FXML
    private Label labelUserAddress;

    @FXML
    private Label labelUserPhone;

    @FXML
    private Label labelUsername;
    @FXML
    private VBox productVBox;
    @FXML
    private Button btnBack, btnBuy;

    @FXML
    private TextField tfUserAddress;

    @FXML
    private TextField tfUserPhone;

    @FXML
    private TextField tfTenNguoiNhan;

    @FXML
    private Scene preScene;
    private Parent preRoot;

    private List<OrderItem> list;

    private String prevScene;
    public void setPreScene(Scene preScene) {
        this.preScene = preScene;
    }

    public void setPrevScene(String prevScene) {
        this.prevScene = prevScene;
    }

    public void setPreRoot(Parent preRoot) {
        this.preRoot = preRoot;
    }

    public void setData(List<OrderItem> list) throws Exception {
        tfTenNguoiNhan.setText(AppLaunch.server.getPersonUsing().getName());
        tfUserAddress.setText(AppLaunch.server.getPersonUsing().getAddress());
        tfUserPhone.setText(AppLaunch.server.getPersonUsing().getPhone());
        this.list = list;
        System.out.println(this.list);
        for(OrderItem oi : list)
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DonHangController.class.getResource("/ProSale/FXML/MuaHangItem.fxml"));
            AnchorPane pane = loader.load();
            MuaHangItemController controller = loader.getController();
            controller.setData(productVBox, oi);
            productVBox.getChildren().add(pane);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list = new ArrayList<OrderItem>();
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) btnBack.getScene().getWindow();
//        Scene scene = new Scene(preRoot);
//        DonHangController donHangController =  (DonHangController) preRoot.getUserData();
//        donHangController.setVboxGioHang(((User)AppLaunch.server.getPersonUsing()).getGioHang());
        stage.setScene(preScene);
        stage.show();

    }

    public void changeToDonHang() throws Exception {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ProSale/FXML/DonHang.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        System.out.println(root.toString());
        DonHangController controller = loader.getController();
        controller.setVboxGioHang(((User)AppLaunch.server.getPersonUsing()).getGioHang());
        stage.setScene(scene);
        stage.show();
    }

    public void changeToProductDetail() throws Exception {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/ProductDetail.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        ProductDetailTabController controller = loader.getController();
        controller.setProduct(AppLaunch.server.getProductMap().get(list.get(0).getProductID()));
        stage.setScene(scene);
    }
    public void btnBuyOnAction(ActionEvent actionEvent) throws Exception {
        if (tfTenNguoiNhan.getText().equals("") || tfUserAddress.getText().equals("") || tfUserPhone.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập đủ thông tin");
            alert.showAndWait();
            return;
        }
        else{
            for(OrderItem orderItem : list) {
                Product product = AppLaunch.server.getProductMap().get(orderItem.getProductID());
                if (product.getQuantity() < orderItem.getQuantity()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ProSale");
                    alert.setHeaderText("Ôi không!");
                    alert.setContentText("Sản phẩm " + product.getName()+ " không còn đủ số lượng");
                    alert.showAndWait();
                    return;
                }
            }

            for(OrderItem orderItem : list) {
                Product product = AppLaunch.server.getProductMap().get(orderItem.getProductID());
                product.setQuantity(product.getQuantity() - orderItem.getQuantity());
                ((User)AppLaunch.server.getPersonUsing()).getGioHang().getOrderItemsList().remove(orderItem);
            }

            Order order = new Order(list);
            order.setOrderTenNguoiNhan(tfTenNguoiNhan.getText());
            order.setOrderAddress(tfUserAddress.getText());
            order.setOrderPhone(tfUserPhone.getText());
            ((User)AppLaunch.server.getPersonUsing()).getOrderList().add(order.getOrderID());
            AppLaunch.server.getOrderMap().put(order.getOrderID(), order);
            AppLaunch.server.getOrderList().add(order);
            IOSystem.saveData();


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ProSale");
            alert.setHeaderText("Xác nhận");
            alert.setContentText("Đã đặt hàng thành công");
            alert.showAndWait();
            for(Integer integer : ((User)AppLaunch.server.getPersonUsing()).getOrderList()){
                Order order1 = AppLaunch.server.getOrderMap().get(integer);
                for(OrderItem oi : order1.getOrderItemsList()){
                    Product product = AppLaunch.server.getProductMap().get(oi.getProductID());
                    System.out.println(product.getName() + "      " + oi.getQuantity());
                }
                System.out.println("-----------------");
            }
            System.out.println("*********************");
        }
    }
}
