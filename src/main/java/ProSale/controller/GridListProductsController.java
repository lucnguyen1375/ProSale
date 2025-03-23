package ProSale.controller;

import ProSale.model.order.Order;
import ProSale.model.product.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GridListProductsController implements Initializable {
    @FXML
    private GridPane gridProduct;
    private MyListener myListener;

    int column = 0, row = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListener = new MyListener() {
            @Override
            public void onClickListenerOrder(Order order){}

            @Override
            public void onClickListenerProduct(Product product){
                System.out.println(product);
                try {
                    Stage stage = new Stage();
                    Stage thisStage = (Stage)gridProduct.getScene().getWindow();
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
    }

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

}
