package ProSale.model.order;

import ProSale.model.product.Product;

public class OrderItem {
    Product product;
    int quantity;

    @Override
    public String toString() {
        return "OrderItem{" + "product=" + product + ", quantity=" + quantity + '}';
    }
}
