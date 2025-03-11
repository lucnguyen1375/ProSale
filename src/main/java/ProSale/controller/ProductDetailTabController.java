package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.manager.IOSystem;
import ProSale.manager.ProductManager;
import ProSale.model.order.Order;
import ProSale.model.order.OrderItem;
import ProSale.model.person.Admin;
import ProSale.model.person.User;
import ProSale.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class ProductDetailTabController implements Initializable {

    private Stage previousStage;
    @FXML
    private Button btnBack;
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
    private TextField tfQuantity1;
    @FXML
    private Button btnIncrease1, btnDecrease1;
    @FXML
    private Button btnEdit, btnAdd;
    @FXML
    private AnchorPane paneAdmin, paneUser;
    @FXML
    private Button btnAddToGioHang, btnBuy;
    private ProductManager productManager;
    Image image;
    private Product product;
    DecimalFormat df = new DecimalFormat("#,###");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (AppLaunch.server.getPersonUsing() instanceof Admin) {
            paneAdmin.setVisible(true);
            paneUser.setVisible(false);
            System.out.println("Admin");
        }
        else {
            paneAdmin.setVisible(false);
            paneUser.setVisible(true);
        }
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
    public void btnAddOnAction(ActionEvent event) throws IOException {
        productManager.addProductQuantity(product, Integer.parseInt(tfQuantity.getText()));
        setProduct(product);
        tfQuantity.setText("0");
    }

    public void btnBackOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/MainView.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        MainViewController controller = loader.getController();
        controller.setProductViewFirst();
        previousStage.setScene(scene);
        previousStage.show();
        stage.close();
        try {
            IOSystem.saveProductData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setMainViewStage(Stage stage) {
        this.previousStage = stage;
    }


    @FXML
    public void btnIncrease1OnAction(ActionEvent event) {
        tfQuantity1.setText(String.valueOf(Integer.parseInt(tfQuantity1.getText()) + 1));
    }
    @FXML
    public void btnDecrease1OnAction(ActionEvent event) {
        tfQuantity1.setText(String.valueOf(Integer.parseInt(tfQuantity1.getText()) - 1));
    }
    public void btnAddToGioHangOnAction(ActionEvent event) throws IOException {
        if (Integer.parseInt(tfQuantity1.getText()) == 0) return;
        for(OrderItem orderItem : ((User)AppLaunch.server.getPersonUsing()).getGioHang().getOrderItemsList())
        {
            if (product.getName().equals(orderItem.getProduct().getName())) {
                orderItem.setQuantity(orderItem.getQuantity() + Integer.parseInt(tfQuantity1.getText()));
                try {
                    IOSystem.savePersonData();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Trung");
                return;
            }
        }
        ((User)AppLaunch.server.getPersonUsing()).getGioHang().getOrderItemsList().add(new OrderItem(product, Integer.parseInt(tfQuantity1.getText())));
        try {
            IOSystem.savePersonData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
