package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.manager.IOSystem;
import ProSale.model.order.GioHang;
import ProSale.model.order.OrderItem;
import ProSale.model.person.User;
import ProSale.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GioHangItemController {

    @FXML
    private Button btnDelete;

    @FXML
    private CheckBox checkBox;

    @FXML
    private ImageView imageView;

    @FXML
    private Label labelName;

    @FXML
    private Label labelPrice;

    @FXML
    private Label labelQuantity;

    @FXML
    private Label labelTotalPrice;

    @FXML
    private Stage stage;
    private VBox parentVBox;  // Tham chiếu đến VBox cha
    private AnchorPane pane;     // Tham chiếu đến chính hàng này

    private List<OrderItem> list;
    private Integer tienHang;
    private Label labelTienHang;

    // Hàm này được gọi từ MainApp để khởi tạo các tham chiếu
    public void initData(VBox parentVBox, AnchorPane pane, List<OrderItem> list, Label labelTienHang) {
        this.parentVBox = parentVBox;
        this.pane = pane;
        this.list = list;
        this.labelTienHang = labelTienHang;
    }
    private Product product;
    private GioHang gioHang;
    private OrderItem orderItem;

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
        this.product = AppLaunch.server.getProductMap().get(orderItem.getProductID());
        Image image = new Image(getClass().getResourceAsStream(product.getSrcImg()));
        imageView.setImage(image);
        labelName.setText(product.getName());
        labelPrice.setText(new DecimalFormat("#,###").format(product.getPrice()) + " VND");
        labelQuantity.setText(String.valueOf(orderItem.getQuantity()));
        labelTotalPrice.setText(new DecimalFormat("#,###").format(product.getPrice() * orderItem.getQuantity()) + " VND");
    }


    public void setCheckBox() {
        if (checkBox.isSelected()) {
            list.add(orderItem);
        }
        else{
            list.remove(orderItem);
        }
        int total = 0;
        for(OrderItem orderItem : list){
            System.out.println("Da tick " + product.getName() + " " + orderItem.getQuantity());
            total += AppLaunch.server.getProductMap().get(orderItem.getProductID()).getPrice() * orderItem.getQuantity();
        }
        System.out.println(total);
        System.out.println("-----------");
        labelTienHang.setText(new DecimalFormat("#,###").format(total) + " VND");
    }

    public void delete(ActionEvent actionEvent) throws IOException {
        parentVBox.getChildren().remove(pane);
        for (OrderItem oi : list) {
            if (oi.getProductID() == product.getId()) {
                list.remove(oi);
                break;
            }
        }
        int total = 0;
        for(OrderItem orderItem : list){
            total += product.getPrice() * orderItem.getQuantity();
        }
        labelTienHang.setText(new DecimalFormat("#,###").format(total) + " VND");


        ((User)AppLaunch.server.getPersonUsing()).getGioHang().getOrderItemsList().remove(orderItem);
        try {
            IOSystem.savePersonData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Đã xóa " + product.getName());
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/MainView.fxml"));
//        Parent parent = loader.load();
//        Scene scene = new Scene(parent);
//        stage.setScene(scene);
    }

    public void setStage(Stage stage) {}
}