module ProSale {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens ProSale to javafx.fxml;
    exports ProSale;
    exports ProSale.controller;
    exports ProSale.model;
    exports ProSale.utilz;
    opens ProSale.controller to javafx.fxml;
    opens ProSale.model to javafx.fxml;
}