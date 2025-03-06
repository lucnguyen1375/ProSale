package ProSale.controller;

import ProSale.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class ProductPreviewHorizontalController {
    @FXML
    private ImageView imgProduct;

    @FXML
    private Label labelProductName;

    @FXML
    private Label labelProductPrice;
    @FXML
    private AnchorPane pane;

    public void paneOnAction(ActionEvent event) {
        System.out.println("lucdz");
    }

    private MyListener myListener;
    private Product product;

    @FXML
    private void click(MouseEvent event) {
        myListener.onClickListener(product);
    }

    public void setData(Product product, MyListener myListener) {
        this.product = product;
        this.myListener = myListener;
        labelProductName.setText(product.getName());
        labelProductPrice.setText(String.valueOf(product.getPrice()) + " VND");
        Image image = new Image(getClass().getResourceAsStream(product.getSrcImg()));
        imgProduct.setImage(image);
    }
}
