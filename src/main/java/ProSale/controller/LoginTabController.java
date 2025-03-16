package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.manager.PersonManager;
import ProSale.manager.UserManager;
import ProSale.model.person.Person;
import ProSale.model.person.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LoginTabController implements Initializable {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;
    protected UserManager userManager = new UserManager();
    protected PersonManager personManager = new PersonManager();
    @FXML
    protected Button btnLogin, btnSignUp;
    @FXML
    protected TextField tfUsername;
    @FXML
    protected PasswordField pfPassword;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnLogin.setDisable(true);
        tfUsername.textProperty().addListener((observable, oldValue, newValue) -> {
            btnLogin.setDisable(newValue.trim().isEmpty());
        });
    }

    public void changeToMainViewTab(ActionEvent event) throws IOException {
        if (personManager.checkIfAccountRight(tfUsername.getText().trim(), pfPassword.getText().trim())) {
            for(Person person : AppLaunch.server.getPersonList()){
                if (person.getUsername().equals(tfUsername.getText().trim()) && person.getPassword().equals(pfPassword.getText().trim())) {
                    AppLaunch.server.setPersonUsing(person);
                    break;
                }
            }
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/MainView.fxml"));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Tài khoản hoặc mật khẩu không đúng");
            alert.showAndWait();
        }
    }

    public void changeToSignUpTab(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/SignUpTab.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }

    @FXML
    Button btnDemo;

    public void btnDemoOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/SignUpTab.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
