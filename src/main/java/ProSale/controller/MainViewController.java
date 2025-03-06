package ProSale.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    Button btnSearch;

    @FXML
    TextField tfSearch;

    @FXML
    HBox searchHbox;

    @FXML
    Button btnProfile, btnGioHang;

    @FXML
    Button btnHome, btnProduct, btnLienHe;
    @FXML
    AnchorPane paneHome, paneLienHe;
    @FXML
    HBox paneProduct;
    @FXML
    ComboBox<String> comboBoxGia, comboBoxChatLieu, comboBoxKichThuoc;
    @FXML
    Button btnPhoBien, btnMoiNhat, btnBanChay;

    @FXML
    Button btnBanPhan, btnGuong, btnGhe, btnTuGiay, btnTuDauGiuong;
    public void demo(ActionEvent event) {
        System.out.println("lucdz");
    }
    public void changeToHome(ActionEvent event) {
        paneHome.setVisible(true);
        paneProduct.setVisible(false);
        paneLienHe.setVisible(false);
    }

    public void changeToLienHe(ActionEvent event) {
        paneLienHe.setVisible(true);
        paneProduct.setVisible(false);
        paneHome.setVisible(false);
    }

    public void changeToProduct(ActionEvent event) {
        paneProduct.setVisible(true);
        paneLienHe.setVisible(false);
        paneHome.setVisible(false);
    }

    public void changeToProfileTab(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/ProfileTab.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneHome.setVisible(true);
        paneProduct.setVisible(false);
        paneLienHe.setVisible(false);
    }
}
