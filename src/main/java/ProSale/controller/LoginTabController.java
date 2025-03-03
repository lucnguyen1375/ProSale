package ProSale.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginTabController implements Initializable {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    @FXML
    protected Button buttonLogIn, buttonSignUp;
    @FXML
    protected TextField textFieldUserName;
    @FXML
    protected PasswordField textFieldPassword;
    @FXML
    private GridPane gridLogIn;
    @FXML
    private Label labelHeader, labelPassword, labelUserName;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonLogIn.setDisable(true);
        textFieldUserName.textProperty().addListener((observable, oldValue, newValue) -> {
            buttonLogIn.setDisable(newValue.trim().isEmpty());
        });
    }

    public void changeToMainViewTab(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/MainView.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }

    public void changeToSignUpTab(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/SignUpTab.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }
}
