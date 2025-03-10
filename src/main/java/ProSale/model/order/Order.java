package ProSale.model.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private List<OrderItem> orderItemsList;

    public Order() {
        orderItemsList = new ArrayList<OrderItem>();
    }

    @Override
    public String toString() {
        return "Order [orderItemsList=" + orderItemsList + "]";
    }

    public List<OrderItem> getOrderItemsList() { return orderItemsList; }
}
