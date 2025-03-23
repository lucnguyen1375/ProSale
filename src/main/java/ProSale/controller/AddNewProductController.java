package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.manager.IOSystem;
import ProSale.manager.SaveImageToResource;
import ProSale.model.product.*;
import ProSale.utilz.ImagePath;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AddNewProductController {

    @FXML
    private Button btnAddProduct, btnAddImage;

    @FXML
    private Button btnBack;

    @FXML
    private ImageView imageProduct;

    @FXML
    private AnchorPane paneUser;

    @FXML
    private TextField tfDescription;

    @FXML
    private TextField tfMaterial;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPrice;

    @FXML
    private TextField tfQuantity;

    @FXML
    private TextField tfSize;

    @FXML
    private ComboBox comboBoxType;

    SaveImageToResource saveImage = new SaveImageToResource();
    String resourcePath, calledPath, tempPath;


    @FXML
    public void btnBackOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/MainView.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        MainViewController controller = loader.getController();
        controller.setProductViewFirst();
        stage.setScene(scene);
    }

    File selectedFile;

    public void btnAddImageOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Hình ảnh", "*.png", "*.jpg", "*.jpeg"));
        selectedFile = fileChooser.showOpenDialog((Stage)(btnAddImage.getScene().getWindow()));

        if (selectedFile != null) {
            try {
                Image image = new Image(selectedFile.toURI().toString());
                imageProduct.setImage(image);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void btnAddProductOnAction(ActionEvent event) throws Exception {
        if (tfName.getText().trim().equals("")
        || tfPrice.getText().trim().equals("")
        || tfSize.getText().trim().equals("")
        || tfMaterial.getText().trim().equals("")
        || tfQuantity.getText().trim().equals("")
        || tfDescription.getText().trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ProSale");
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng nhập đủ thông tin sản phẩm");
            alert.showAndWait();
        }
        else if (comboBoxType.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ProSale");
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng chọn loại sản phẩm");
            alert.showAndWait();
        }
        else if (selectedFile == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ProSale");
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng chọn ảnh");
            alert.showAndWait();
        }
        else{
            Product product = null;
            if (comboBoxType.getSelectionModel().getSelectedItem().equals("Bàn phấn")) {
                resourcePath = ImagePath.BAN_PHAN_PATH;
                tempPath = "/ProSale/images/product/banPhan/";
                product = new BanPhan(tfName.getText(), Integer.parseInt(tfPrice.getText()),"",
                        tfMaterial.getText(), tfSize.getText(), tfDescription.getText(), Integer.parseInt(tfQuantity.getText()));
            }
            else if (comboBoxType.getSelectionModel().getSelectedItem().equals("Ghế")) {
                resourcePath = ImagePath.GHE_PATH;
                tempPath = "/ProSale/images/product/ghe/";
                product = new Ghe(tfName.getText(), Integer.parseInt(tfPrice.getText()),"",
                        tfMaterial.getText(), tfSize.getText(), tfDescription.getText(), Integer.parseInt(tfQuantity.getText()));

            }
            else if (comboBoxType.getSelectionModel().getSelectedItem().equals("Gương")) {
                resourcePath = ImagePath.GUONG_PATH;
                tempPath = "/ProSale/images/product/guong/";
                product = new Guong(tfName.getText(), Integer.parseInt(tfPrice.getText()),"",
                        tfMaterial.getText(), tfSize.getText(), tfDescription.getText(), Integer.parseInt(tfQuantity.getText()));

            }
            else if (comboBoxType.getSelectionModel().getSelectedItem().equals("Tủ giày")) {
                resourcePath = ImagePath.TU_GIAY_PATH;
                tempPath = "/ProSale/images/product/tuGiay/";
                product = new TuGiay(tfName.getText(), Integer.parseInt(tfPrice.getText()),"",
                        tfMaterial.getText(), tfSize.getText(), tfDescription.getText(), Integer.parseInt(tfQuantity.getText()));

            }
            else if (comboBoxType.getSelectionModel().getSelectedItem().equals("Tủ đầu giường")) {
                resourcePath = ImagePath.TU_DAU_GIUONG_PATH;
                tempPath = "/ProSale/images/product/tuDauGiuong/";
                product = new TuDauGiuong(tfName.getText(), Integer.parseInt(tfPrice.getText()),"",
                        tfMaterial.getText(), tfSize.getText(), tfDescription.getText(), Integer.parseInt(tfQuantity.getText()));
            }

            calledPath = resourcePath + saveImage.saveImageToResources(selectedFile, resourcePath);

            product.setSrcImg(calledPath);
            product.in();
            AppLaunch.server.getProductList().add(product);
            AppLaunch.server.getProductMap().put(product.getId(), product);
            IOSystem.saveData();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ProSale");
            alert.setHeaderText("Xác nhận");
            alert.setContentText("Đã thêm sản phẩm thành công");
            alert.showAndWait();
        }
    }

}
