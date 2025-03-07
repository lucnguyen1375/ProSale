package ProSale.controller;


import ProSale.model.product.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductDetailTabController
//                                implements Initializable
{

    @FXML
    private Label labelName;
    @FXML
    private Label labelDescription;

    @FXML
    private Label labelMaterial;

    @FXML
    private Label labelPrice;

    @FXML
    private Label labelQuantity;

    @FXML
    private Label labelSize;

    @FXML
    private Label labelType;

    public static Product product;
    public void setProduct(Product product) {
        this.product = product;
    }
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        labelName.setText(product.getName());
//        labelDescription.setText(product.getDescription());
//        labelMaterial.setText(product.getMaterial());
//        labelPrice.setText(String.valueOf(product.getPrice()));
//        labelQuantity.setText(String.valueOf(product.getQuantity()));
//        labelSize.setText(product.getSize());
//        labelType.setText(product.getType());
//
//    }
}
