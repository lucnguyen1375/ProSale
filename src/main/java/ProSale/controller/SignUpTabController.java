package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.manager.IOSystem;
import ProSale.manager.PersonManager;
import ProSale.model.person.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;


public class SignUpTabController{
    Alert alert;
    ObjectOutputStream oos;
    PersonManager personManager = new PersonManager();
    @FXML
    private Button btnCancel, btnSignUp;

    @FXML
    private TextField tfAddress, tfEmail, tfGender, tfName, tfPhone;

    @FXML
    private PasswordField pfPassword, pfConfirmPassword;

    @FXML
    private TextField tfUsername;

    public void signUp(ActionEvent event) throws Exception{
        // Điền đủ thông tin
        if (!tfName.getText().trim().isEmpty() && !pfPassword.getText().trim().isEmpty() && !pfConfirmPassword.getText().trim().isEmpty() && !tfUsername.getText().trim().isEmpty()) {
            if (tfUsername.getText().trim().contains(" ") || pfPassword.getText().trim().contains(" ")) {
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ProSale");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Tài khoản và mật khẩu không chưa dấu cách.");
            }
            // Kiểm tra tài khoản tồn tại chưa
            else if (personManager.checkIfUsernameExists(tfUsername.getText())) {
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Tài khoản đã tồn tại");
            }
            // Điền đúng mật khẩu
            else if (pfPassword.getText().trim().equals(pfConfirmPassword.getText().trim())) {
                User user = new User(tfUsername.getText().trim(), pfPassword.getText().trim(), tfName.getText().trim(), tfGender.getText().trim(), tfAddress.getText().trim(), tfPhone.getText().trim(), tfEmail.getText().trim());
//                AppLaunch.server.get
                personManager.savePerson(user);
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Đăng ký tài khoản thành công");
                try {
                    IOSystem.saveIDData();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Mật khẩu không khớp");
            }
        }
        else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng điền đủ thông tin bắt buộc");
        }
        alert.showAndWait();
    }

    public void changeToLoginTab(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/LoginTab.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }
}