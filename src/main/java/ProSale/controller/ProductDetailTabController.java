package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.manager.IOSystem;
import ProSale.manager.ProductManager;
import ProSale.model.order.OrderItem;
import ProSale.model.person.Admin;
import ProSale.model.person.User;
import ProSale.model.product.Product;
import ProSale.utilz.FormatterFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProductDetailTabController implements Initializable {

    private Stage previousStage;
    @FXML
    private Button btnBack;
    @FXML
    private Label labelProductID, labelDescription, labelPrice,
            labelMaterial, labelName, labelQuantity, labelSize;

    @FXML
    private ImageView imageProduct;
    @FXML
    private TextField tfQuantityAdd;
    @FXML
    private Button btnIncrease, btnDecrease;
    @FXML
    private TextField tfQuantityBuy;
    @FXML
    private Button btnIncrease1, btnDecrease1;
    @FXML
    private Button btnEdit, btnAdd;
    @FXML
    private AnchorPane paneAdmin, paneUser;
    @FXML
    private Button btnAddToGioHang, btnBuy, btnGioHang;
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
//        tfQuantityAdd.setTextFormatter(new javafx.scene.control.TextFormatter<String>(change -> {
//            String newText = change.getControlNewText();
//            if (newText.matches("\\d*")) { // Chỉ cho phép ký tự là số
//                return change;  // Cho phép thay đổi nếu là số
//            }
//            return null; // Từ chối nếu không phải là số
//        }));
        tfQuantityAdd.setTextFormatter(FormatterFactory.createIntegerFormatter());
        tfQuantityBuy.setTextFormatter(FormatterFactory.createIntegerFormatter());

    }

    public void setProduct(Product product) {
        this.product = product;
        labelName.setText(product.getName());
        labelProductID.setText(String.valueOf(product.getId()));
        labelDescription.setText(product.getDescription());
        labelMaterial.setText(product.getMaterial());
        labelQuantity.setText(String.valueOf(product.getQuantity()));
        labelSize.setText(product.getSize());
        labelPrice.setText(df.format(product.getPrice()) + " VND");
        File file = new File(product.getSrcImg());
        image = new Image(file.toURI().toString());
//        File file = new File(product.set)
//        image = new Image(getClass().getResourceAsStream(product.getSrcImg()));
        imageProduct.setImage(image);
    }


    @FXML
    public void btnIncreaseAddOnAction(ActionEvent event) {
        tfQuantityAdd.setText(String.valueOf(Integer.parseInt(tfQuantityAdd.getText()) + 1));
    }
    @FXML
    public void btnDecreaseAddOnAction(ActionEvent event) {
        tfQuantityAdd.setText(String.valueOf(Integer.parseInt(tfQuantityAdd.getText()) - 1));
    }
    @FXML
    public void btnAddOnAction(ActionEvent event) throws IOException {
        productManager.addProductQuantity(product, Integer.parseInt(tfQuantityAdd.getText()));
        setProduct(product);
        tfQuantityAdd.setText("0");
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

    public void setPreviousStage(Stage stage) {
        this.previousStage = stage;
    }

    @FXML
    public void btnIncreaseBuyOnAction(ActionEvent event) {
        tfQuantityBuy.setText(String.valueOf(Integer.parseInt(tfQuantityBuy.getText()) + 1));
    }
    @FXML
    public void btnDecreaseBuyOnAction(ActionEvent event) {
        tfQuantityBuy.setText(String.valueOf(Integer.parseInt(tfQuantityBuy.getText()) - 1));
    }

    public void btnAddToGioHangOnAction(ActionEvent event) throws Exception {
        if (Integer.parseInt(tfQuantityBuy.getText()) == 0)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập số lượng sản phẩm");
            alert.showAndWait();
            return;
        }

        Boolean productInGioHang = false;

        for(OrderItem orderItem : ((User)AppLaunch.server.getPersonUsing()).getGioHang().getOrderItemsList()) {
            if (orderItem.getProductID() == product.getId()) {
                orderItem.setQuantity(orderItem.getQuantity() + Integer.parseInt(tfQuantityBuy.getText()));
                productInGioHang = true;
            }
        }

        if (productInGioHang == false) {
            OrderItem orderItem = new OrderItem(product.getId(), Integer.parseInt(tfQuantityBuy.getText()));
            ((User)AppLaunch.server.getPersonUsing()).getGioHang().getOrderItemsList().add(orderItem);
        }
        tfQuantityBuy.setText("0");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ProSale");
        alert.setHeaderText("Xác nhận");
        alert.setContentText("Đã thêm vào giỏ hàng thành công.");
        alert.showAndWait();

        IOSystem.savePersonData();
    }

    public void btnBuyOnAction(ActionEvent event) throws Exception {
        if (Integer.parseInt(tfQuantityBuy.getText()) == 0)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập số lượng sản phẩm");
            alert.showAndWait();
            return;
        }

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/MuaHang.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        MuaHangController controller = loader.getController();
        List<OrderItem> list = new ArrayList<OrderItem>();
        OrderItem orderItem = new OrderItem(product.getId(), Integer.parseInt(tfQuantityBuy.getText()));
        System.out.println(tfQuantityBuy.getText());
        list.add(orderItem);
        controller.setPreScene(((Node)event.getSource()).getScene());
        controller.setPrevScene("ProductDetail");
        controller.setData(list);

        stage.setScene(scene);
        tfQuantityBuy.setText("0");
    }

    public void btnGioHangOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/DonHang.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        DonHangController controller = loader.getController();
        controller.setPreScene(((Node)event.getSource()).getScene());
        stage.setScene(scene);
    }

    public void reload() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/ProductDetail.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
    }
}
