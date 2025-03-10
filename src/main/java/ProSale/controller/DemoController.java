package ProSale.controller;

import ProSale.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DemoController {
    @FXML
    Button btnDone;
    @FXML
    TextField tfName, tfPrice,tfQuantity;

    public void btnDoneOnAction(ActionEvent event) {
        Product product = new Product();
        product.setName(tfName.getText());
        product.setPrice(Integer.parseInt(tfPrice.getText()));
        product.setQuantity(Integer.parseInt(tfQuantity.getText()));
        System.out.println(product);

    }
}
