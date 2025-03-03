package ProSale.controller;

import ProSale.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileTabController{
    @FXML
    private Button btnEdit;

    @FXML
    private Label labelAddress,labelAge, labelEmail, labelGender, labelName, labelPhone, labelUsername;

    @FXML
    public void setScene(User user) {
        labelName.setText(String.valueOf(user.getName()));
        labelAddress.setText(String.valueOf(user.getAddress()));
        labelAge.setText(String.valueOf(user.getAge()));
        labelEmail.setText(String.valueOf(user.getEmail()));
        labelGender.setText(String.valueOf(user.getGender()));
        labelPhone.setText(String.valueOf(user.getPhone()));
        labelUsername.setText(String.valueOf(user.getUsername()));
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
