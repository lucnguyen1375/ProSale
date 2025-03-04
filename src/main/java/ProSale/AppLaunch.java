package ProSale;

import ProSale.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AppLaunch extends Application {
    public static AppServer server;
    List<User> users;
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage){
        server = new AppServer();
        for(User user : server.getUserList()){
            System.out.println(user);
        }
        try{
            //FXMLLoader fxmlLoader = new FXMLLoader(AppLaunch.class.getResource("FXML/LoginTab.fxml"));
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
