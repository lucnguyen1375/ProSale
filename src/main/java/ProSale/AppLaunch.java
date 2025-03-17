package ProSale;

import ProSale.manager.IOSystem;
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
        server.setProductMap();
        System.out.println(server.getPersonList());
        try{
            Parent root = FXMLLoader.load(getClass().getResource("FXML/LoginTab.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("ProSale");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
