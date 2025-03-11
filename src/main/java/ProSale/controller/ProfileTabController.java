package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.person.Person;
import ProSale.model.person.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileTabController implements Initializable {
    @FXML
    private Button btnHoso, btnDonHang;
    @FXML
    private VBox paneHoSo;
    @FXML
    private AnchorPane paneDonHang;
    @FXML
    private Button btTroVe, btnDangXuat;
    @FXML
    private Label labelName, labelID, labelEmail, labelPhone, labelGender, labelAddress;

    private Person personUsing;

    private void setPersonUsing(){
        personUsing = AppLaunch.server.getPersonUsing();
        labelID.setText(String.valueOf(personUsing.getId()));
        labelName.setText(personUsing.getName());
        labelEmail.setText(personUsing.getEmail());
        labelPhone.setText(personUsing.getPhone());
        labelGender.setText(personUsing.getGender());
        labelAddress.setText(personUsing.getAddress());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setPersonUsing();
        paneHoSo.setVisible(true);
        paneDonHang.setVisible(false);
    }

    public void btnHosoOnAction(ActionEvent actionEvent) {
        paneHoSo.setVisible(true);
        paneDonHang.setVisible(false);
    }
    public void btnDonHangOnAction(ActionEvent actionEvent) {
        paneDonHang.setVisible(true);
        paneHoSo.setVisible(false);
    }

    public void btnDangXuatOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/LoginTab.fxml"));
        Parent mainViewParent = loader.load();
        Scene mainViewScene = new Scene(mainViewParent);
        stage.setScene(mainViewScene);
    }
    @FXML
    public void changeToMainViewTab(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/MainView.fxml"));
        Parent mainViewParent = loader.load();
        Scene mainViewScene = new Scene(mainViewParent);
        stage.setScene(mainViewScene);
    }
}
