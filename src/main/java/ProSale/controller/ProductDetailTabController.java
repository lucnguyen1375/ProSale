package ProSale.controller;

import ProSale.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class ProductDetailTabController implements Initializable {
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
    @FXML
    private TextField tfQuantity;
    @FXML
    private Button btnIncrease, btnDecrease;
    @FXML
    private Button btnEdit, btnAdd;
    private ProductManager productManager;
    Image image;
    private Product product;
    DecimalFormat df = new DecimalFormat("#,###");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productManager = new ProductManager();
        tfQuantity.setTextFormatter(new javafx.scene.control.TextFormatter<String>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) { // Chỉ cho phép ký tự là số
                return change;  // Cho phép thay đổi nếu là số
            }
            return null; // Từ chối nếu không phải là số
        }));
    }
    public void setProduct(Product product) {
        this.product = product;
        labelName.setText(product.getName());
//        labelName.textProperty().bind(product.getName());
        //labelDescription.textProperty().bind(product.getDescription());
        labelDescription.setText(product.getDescription());
        labelMaterial.setText(product.getMaterial());
        labelQuantity.setText(String.valueOf(product.getQuantity()));
        labelSize.setText(product.getSize());
        labelPrice.setText(df.format(product.getPrice()) + " VND");
        image = new Image(getClass().getResourceAsStream(product.getSrcImg()));
        imageProduct.setImage(image);
    }


    @FXML
    public void btnIncreaseOnAction(ActionEvent event) {
        tfQuantity.setText(String.valueOf(Integer.parseInt(tfQuantity.getText()) + 1));
    }
    @FXML
    public void btnDecreaseOnAction(ActionEvent event) {
        tfQuantity.setText(String.valueOf(Integer.parseInt(tfQuantity.getText()) - 1));
    }
    @FXML
    public void btnAddOnAction(ActionEvent event) {
        productManager.addProductQuantity(product, Integer.parseInt(tfQuantity.getText()));
        setProduct(product);

    }
}
