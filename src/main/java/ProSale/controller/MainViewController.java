package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.person.Admin;
import ProSale.model.product.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    private MyListener myListener;
    @FXML
    private Button btnSearch;

    @FXML
    private TextField tfSearch;

    @FXML
    private HBox searchHbox;

    @FXML
    private Button btnProfile, btnDonHang;

    @FXML
    private Button btnHome, btnProduct, btnLienHe;
    @FXML
    private AnchorPane paneHome, paneLienHe;
    @FXML
    private StackPane paneProduct;
    @FXML
    private ComboBox<String> comboBoxGia, comboBoxChatLieu, comboBoxKichThuoc;
    @FXML
    private Button btnPhoBien, btnMoiNhat, btnBanChay;
    @FXML
    private GridPane gridProduct;
    @FXML
    private Button btnALLProducts, btnBanPhan, btnGuong, btnGhe, btnTuGiay, btnTuDauGiuong;
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Stage stage;

    @FXML
    private Button btnAdd, btnGioHang;

    public void changeToHome(ActionEvent event) {
        paneHome.setVisible(true);
        paneProduct.setVisible(false);
        paneLienHe.setVisible(false);
    }

    public void changeToLienHe(ActionEvent event) {
        paneLienHe.setVisible(true);
        paneProduct.setVisible(false);
        paneHome.setVisible(false);
    }

    public void changeToProduct(ActionEvent event) {
        paneProduct.setVisible(true);
        paneLienHe.setVisible(false);
        paneHome.setVisible(false);
    }

    public void changeToProfileTab(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/ProfileTab.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }


    public void changeToDonHang(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/DonHang.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        DonHangController controller = loader.getController();
        controller.setPreScene(((Node)event.getSource()).getScene());
        stage.setScene(scene);
    }

    int column = 0, row = 0;

    public void setGridProduct(Product product) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ProSale/FXML/ProductPreviewHorizontal.fxml"));
        AnchorPane anchorPane = loader.load();
        ProductPreviewHorizontalController controller = loader.getController();
        controller.setData(product, myListener);

        if(column == 3) {
            column = 0;
            row++;
        }
        gridProduct.add(anchorPane, column++, row);
        GridPane.setMargin(anchorPane, new Insets(10));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneHome.setVisible(true);
        paneProduct.setVisible(false);
        paneLienHe.setVisible(false);
        if (AppLaunch.server.getPersonUsing() instanceof Admin){
            btnAdd.setVisible(true);
            //btnGioHang.setVisible(false);
        }else {
            btnAdd.setVisible(false);
        }
        myListener = new MyListener() {
            @Override
            public void onClickListener(Product product) {
                System.out.println(product);

                try {
                    Stage stage = new Stage();
                    Stage thisStage = (Stage)paneProduct.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/ProductDetail.fxml"));
                    Parent parent = loader.load();
                    Scene scene = new Scene(parent);
                    ProductDetailTabController productDetailTabController = loader.getController();
                    productDetailTabController.setProduct(product);
                    productDetailTabController.setPreviousStage(thisStage);
                    stage.setScene(scene);
                    stage.show();
                    thisStage.hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        try {
            for(Product product : AppLaunch.server.getProductList()) {
                setGridProduct(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProductViewFirst(){
        paneProduct.setVisible(true);
        paneLienHe.setVisible(false);
        paneHome.setVisible(false);
    }

    public void changeToAdminTab(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/AdminTab.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }

    public void btnGioHangOnAction(ActionEvent event) throws IOException {
        if (AppLaunch.server.getPersonUsing() instanceof Admin){
            changeToAdminTab(event);
        }
        else changeToDonHang(event);
    }
    public void btnALlProductsOnAction(ActionEvent event) {
        column = 0; row = 0;
        gridProduct.getChildren().clear();
        try {
            for(Product product : AppLaunch.server.getProductList()) {
                setGridProduct(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnBanPhanOnAction(ActionEvent event) {
        column = 0; row = 0;
        gridProduct.getChildren().clear();
        try {
            for(Product product : AppLaunch.server.getProductList()) {
                if (product instanceof BanPhan == false) continue;
                setGridProduct(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnGuongOnAction(ActionEvent event) {
        column = 0; row = 0;
        gridProduct.getChildren().clear();
        try {
            for(Product product : AppLaunch.server.getProductList()) {
                if (product instanceof Guong == false) continue;
                setGridProduct(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnGheOnAction(ActionEvent event) {
        column = 0; row = 0;
        gridProduct.getChildren().clear();
        try {
            for(Product product : AppLaunch.server.getProductList()) {
                if (product instanceof Ghe == false) continue;
                setGridProduct(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnTuGiayOnAction(ActionEvent event) {
        column = 0; row = 0;
        gridProduct.getChildren().clear();
        try {
            for(Product product : AppLaunch.server.getProductList()) {
                if (product instanceof TuGiay == false) continue;
                setGridProduct(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnTuDauGiuongOnAction(ActionEvent event) {
        column = 0; row = 0;
        gridProduct.getChildren().clear();
        try {
            for(Product product : AppLaunch.server.getProductList()) {
                if (product instanceof TuDauGiuong == false) continue;
                setGridProduct(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnAddOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProSale/FXML/AddProduct.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
