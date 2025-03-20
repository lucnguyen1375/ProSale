package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.order.Order;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminTabController implements Initializable {
    @FXML
    AnchorPane pane;

    public void setDonHangPane() throws IOException {
//        pane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ProSale/FXML/AdminDonHang.fxml"));
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
}
