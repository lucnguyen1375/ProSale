module ProSale {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens ProSale to javafx.fxml;
    exports ProSale;
    exports ProSale.controller;
    opens ProSale.controller to javafx.fxml;
    exports ProSale.model.product;
    opens ProSale.model.product to javafx.fxml;
    opens ProSale.manager to javafx.fxml;
    exports ProSale.manager;
//    exports ProSale.model.person;
//    opens ProSale.model.person to javafx.fxml;
}