package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.order.GioHang;
import ProSale.model.order.OrderItem;
import ProSale.model.person.User;
import ProSale.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DonHangController implements Initializable {
    private Stage thisStage;
    @FXML
    private Button btnDonHang;

    @FXML
    private Button btnGioHang;

    @FXML
    private Button btnTroVe;

    @FXML
    private AnchorPane paneDonHang;

    @FXML
    private AnchorPane paneGioHang;

    @FXML
    private AnchorPane paneNoiDung;

    @FXML
    private VBox vboxGioHang;

    @FXML
    private Label labelTienHang;
    @FXML
    private Button btnBuy;


    Integer tienHang;
    private List<OrderItem> list = new ArrayList<>();

    public void setVboxGioHang(GioHang gioHang) throws Exception{
        for(OrderItem orderItem : gioHang.getOrderItemsList()){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DonHangController.class.getResource("/ProSale/FXML/GioHangItem.fxml"));
            AnchorPane pane = loader.load();
            GioHangItemController controller = loader.getController();
            controller.setOrderItem(orderItem);
            controller.initData(vboxGioHang, pane, list, labelTienHang);
            vboxGioHang.getChildren().add(pane);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneGioHang.setVisible(true);
        paneDonHang.setVisible(false);
        tienHang = 0;
        labelTienHang.setText("0");
        try {
            setVboxGioHang(((User)AppLaunch.server.getPersonUsing()).getGioHang());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void changeToMainView(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/MainView.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }

    public void btnBuyOnAction(ActionEvent event) throws IOException {
        if (list.size() == 0)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng chọn sản phẩm.");
            alert.showAndWait();
            return;
        }
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/MuaHang.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        MuaHangController controller = loader.getController();
        try {
            controller.setPreScene(((Node)event.getSource()).getScene());
            controller.setData(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        stage.setScene(scene);
    }

}