module ProSale {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens ProSale to javafx.fxml;
    exports ProSale;
    exports ProSale.Controller;
    exports ProSale.Model;
    opens ProSale.Controller to javafx.fxml;
    opens ProSale.Model to javafx.fxml;
}