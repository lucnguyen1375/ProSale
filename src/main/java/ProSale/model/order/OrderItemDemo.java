package ProSale.model.order;

import java.io.Serializable;

public class OrderItemDemo implements Serializable {
    private int productID;
    private int quantity;

    public OrderItemDemo(){}

    public OrderItemDemo(int productID, int quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "productID=" + productID + ", quantity=" + quantity + '}';
    }

    public int getProduct() {
        return productID;
    }

    public void setProduct(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
