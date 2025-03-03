package ProSale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLaunch extends Application {
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage){
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
