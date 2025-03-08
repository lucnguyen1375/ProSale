package ProSale.controller;

import ProSale.model.product.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;

public class ProductDetailTabController {

    @FXML
    private Label labelDescription;
    @FXML
    private Label labelPrice;
    @FXML
    private Label labelMaterial;

    @FXML
    private Label labelName;

    @FXML
    private Label labelQuantity;

    @FXML
    private Label labelSize;
    @FXML
    private ImageView imageProduct;

    Image image;
    private Product product;
    DecimalFormat df = new DecimalFormat("#,###");

    public void setProduct(Product product) {
        this.product = product;
        labelName.setText(product.getName());
        labelDescription.setText(product.getDescription());
        labelMaterial.setText(product.getMaterial());
        labelQuantity.setText(String.valueOf(product.getQuantity()));
        labelSize.setText(product.getSize());
        labelPrice.setText(df.format(product.getPrice()) + " VND");
        image = new Image(getClass().getResourceAsStream(product.getSrcImg()));
        imageProduct.setImage(image);
    }
//    public void setLabel(Product product){
//        labelName.setText(product.getName());
//        labelDescription.setText(product.getDescription());
//        labelMaterial.setText(product.getMaterial());
//        labelQuantity.setText(String.valueOf(product.getQuantity()));
//        labelSize.setText(String.valueOf(product.getSize()));
//        labelPrice.setText(String.valueOf(product.getPrice()) + "VND");
//
//    }
}
