package ProSale.model.order;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private int productID;
    private int quantity;

    public OrderItem(){}

    public OrderItem(int productID, int quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "productID=" + productID + ", quantity=" + quantity + '}';
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
