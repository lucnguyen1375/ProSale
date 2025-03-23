package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.order.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminTabController implements Initializable {
    @FXML
    AnchorPane pane;

    @FXML
    Button btnKhoHang, btnDonHang, btnKhachHang, btnThongKe;

    public void setDonHangPane() throws IOException {
//        pane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ProSale/FXML/AdminDonHang.fxml"));
        AnchorPane pane = loader.load();
        this.pane.getChildren().setAll(pane);
    }

    public void setThongKePane() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ProSale/FXML/ThongKe.fxml"));
        AnchorPane pane = loader.load();
        this.pane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setDonHangPane();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDonHangOnAction(ActionEvent actionEvent) throws IOException {setDonHangPane();}
    public void btnThongKeOnAction(ActionEvent actionEvent) throws IOException {setThongKePane();}
}
