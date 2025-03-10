package ProSale.model.order;

import ProSale.model.product.Product;

import java.io.Serializable;

public class OrderItem implements Serializable {
    Product product;
    int quantity;

    public OrderItem(){}

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "product=" + product + ", quantity=" + quantity + '}';
    }
}
