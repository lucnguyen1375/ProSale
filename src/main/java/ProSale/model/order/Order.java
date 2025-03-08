package ProSale.model.order;

import java.util.List;

public class Order {
    private List<OrderItem> orderList;

    @Override
    public String toString() {
        return "Order [orderList=" + orderList + "]";
    }
}
