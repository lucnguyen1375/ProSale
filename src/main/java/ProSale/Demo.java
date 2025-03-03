package ProSale;

import ProSale.Controller.ProfileTabController;
import ProSale.Model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Demo extends Application {
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage){
        try{
            User user = new User("luc", 19, "Nam", "Ha Noi", "0369041397", "luchuubang@gmail.com");
            //FXMLLoader fxmlLoader = new FXMLLoader(AppLaunch.class.getResource("FXML/LoginTab.fxml"));
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/ProfileTab.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            ProfileTabController profileTabController = loader.getController();
            profileTabController.setScene(user);
            stage.setTitle("ProSale");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
