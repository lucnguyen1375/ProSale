package ProSale.controller;

import ProSale.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AddProductController {

    @FXML
    private Button btnAddProduct;

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

    public void btnAddProductOnAction(ActionEvent event) throws IOException {
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
        else{
            Product product = null;
            try {
                product = new Product(tfName.getText(), Integer.parseInt(tfPrice.getText()),"",
                tfMaterial.getText(), tfSize.getText(), tfDescription.getText(), Integer.parseInt(tfQuantity.getText()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            product.setSrcImg(imageProduct.getImage().getUrl());
            System.out.println(product.getSrcImg());
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/ProductDetail.fxml"));
//            Parent parent = loader.load();
//            Scene scene = new Scene(parent);
//            ProductDetailTabController controller = loader.getController();
//            controller.setProduct(product);
//            Stage stage = new Stage();
//            stage.setScene(scene);
        }
    }

}
