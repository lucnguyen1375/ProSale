package ProSale.model.order;

import ProSale.model.product.Product;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private Product product;
    private int quantity;

    public OrderItem(){}

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "product=" + product + ", quantity=" + quantity + '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
