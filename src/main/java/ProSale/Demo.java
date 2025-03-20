package ProSale;

import ProSale.manager.IOSystem;
import ProSale.model.order.Order;
import ProSale.model.order.OrderItem;
import ProSale.model.product.BanPhan;
import ProSale.model.product.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Demo extends Application {
    public static AppServer server;
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        server = new AppServer();
        IOSystem.loadData(server);
        server.setProductMap();
        System.out.println(server.getPersonList());
        Parent root = FXMLLoader.load(getClass().getResource("FXML/DonHangItem.fxml"));
        OrderItem orderItem = new OrderItem(1,1);
        OrderItem orderItem2 = new OrderItem(2,2);
        Order order = new Order();
        order.getOrderItemsList().add(orderItem);
        order.getOrderItemsList().add(orderItem2);
        Scene scene = new Scene(root);
        stage.setTitle("ProSale");
        stage.setScene(scene);
        stage.show();
    }
}