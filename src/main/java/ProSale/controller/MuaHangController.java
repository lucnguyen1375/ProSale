package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.order.OrderItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    private TextField tfUserName;

    @FXML
    private Scene preScene;
    List<OrderItem> list;

    public void setPreScene(Scene preScene) {
        this.preScene = preScene;
    }

    public void setData(List<OrderItem> list) throws Exception {
        tfUserName.setText(AppLaunch.server.getPersonUsing().getName());
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

    public void btnBackOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(preScene);
        stage.show();
    }

    public void btnBuyOnAction(ActionEvent actionEvent) {
        if (tfUserName.getText().equals("") || tfUserAddress.getText().equals("") || tfUserPhone.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập đủ thông tin");
            alert.showAndWait();
            return;
        }

    }
}
