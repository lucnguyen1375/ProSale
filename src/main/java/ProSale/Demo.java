package ProSale;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Lớp Person với thuộc tính name là một Property
class Person {
    private final StringProperty name = new SimpleStringProperty();

    public StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}

public class Demo extends Application {

    @Override
    public void start(Stage stage) {
        Person person = new Person();  // Tạo đối tượng Person
        person.setName("Nguyen Van A"); // Đặt tên ban đầu

        TextField textField = new TextField();
        Label label = new Label();

        // Ràng buộc hai chiều giữa textField và thuộc tính name của person
        textField.textProperty().bindBidirectional(person.nameProperty());

        // Ràng buộc một chiều giữa label và thuộc tính name của person
        label.textProperty().bind(person.nameProperty());

        VBox root = new VBox(10, textField, label);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Ràng buộc thuộc tính của đối tượng");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}