package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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

    public void setVboxGioHang(Product product) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DonHangController.class.getResource("/ProSale/FXML/GioHangItem.fxml"));
        AnchorPane pane = loader.load();
        GioHangItemController controller = loader.getController();
        controller.setData(product);
        controller.initData(vboxGioHang, pane);
        vboxGioHang.getChildren().add(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneGioHang.setVisible(true);
        paneDonHang.setVisible(false);

        try{
           for(Product product: AppLaunch.server.getProductList())
                setVboxGioHang(product);
           for(Product product: AppLaunch.server.getProductList())
                setVboxGioHang(product);
           for(Product product: AppLaunch.server.getProductList())
                setVboxGioHang(product);
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
}