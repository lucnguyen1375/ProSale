package ProSale;

import ProSale.model.person.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.List;

public class Demo extends Application {
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("FXML/Demo.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("ProSale");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}