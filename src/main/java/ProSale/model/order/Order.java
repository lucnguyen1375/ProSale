package ProSale.model.order;

import ProSale.AppLaunch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private List<OrderItem> orderItemsList;
    private int orderID;
    private String orderDate;
    private String orderStatus;
    private int customerID;
//    private int orderPhone;
//    private int customerAddress;
    public Order() {
        orderItemsList = new ArrayList<OrderItem>();
        orderID = AppLaunch.server.getIdManager().getCURRENT_ORDER_ID();
        orderStatus = "Chờ xác nhận";
        customerID = AppLaunch.server.getPersonUsing().getId();
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Order [orderItemsList=" + orderItemsList + "]";
    }

    public List<OrderItem> getOrderItemsList() { return orderItemsList; }
}
