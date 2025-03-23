package ProSale.controller;

import ProSale.model.order.Order;
import ProSale.model.product.Product;
import javafx.scene.input.MouseEvent;

public interface MyListener {
    public void onClickListenerProduct(Product product);
    public void onClickListenerOrder(Order order);
}
