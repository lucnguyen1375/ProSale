package ProSale;

import ProSale.controller.DonHangItemController;
import ProSale.manager.IOSystem;
import ProSale.model.order.Order;
import ProSale.model.order.OrderItem;
import ProSale.model.person.Person;
import ProSale.model.person.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class AppLaunch extends Application {
    public static AppServer server;
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        server = new AppServer();
        IOSystem.loadData(server);
        server.setMap();
        System.out.println(server.getPersonList());
        for(Person person : server.getPersonMap().values()) {
            System.out.println(person);
        }

        Parent root = FXMLLoader.load(getClass().getResource("FXML/LoginTab.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("ProSale");
        stage.setScene(scene);
        stage.show();

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/DonHangItem.fxml"));
//        Parent root = loader.load();
//        OrderItem orderItem = new OrderItem(1,1);
//        OrderItem orderItem2 = new OrderItem(2,2);
//        Order order = new Order();
//        order.getOrderItemsList().add(orderItem);
//        order.getOrderItemsList().add(orderItem2);
//        Scene scene = new Scene(root);
//        DonHangItemController controller = loader.getController();
//        controller.setVboxItem(order);
//        stage.setTitle("ProSale");
//        stage.setScene(scene);
//        stage.show();
    }
}
