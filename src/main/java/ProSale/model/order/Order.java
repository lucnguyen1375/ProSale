package ProSale.model.order;

import ProSale.AppLaunch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private List<OrderItem> orderItemsList;
    private int orderID;
    private Date orderDate;
    private String orderStatus;
    private int customerID;
    private int orderPhone;
    private int orderAddress;

    public Order(List<OrderItem> orderItemsList) throws Exception{
        this.orderItemsList = orderItemsList;
        orderID = AppLaunch.server.getIdManager().getCURRENT_ORDER_ID();
        orderStatus = "Chờ xác nhận";
        customerID = AppLaunch.server.getPersonUsing().getId();
        orderDate = new Date();
    }
    public Order() {
        orderItemsList = new ArrayList<OrderItem>();
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setOrderItemsList(List<OrderItem> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(int orderPhone) {
        this.orderPhone = orderPhone;
    }

    public int getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(int orderAddress) {
        this.orderAddress = orderAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderItemsList=" + orderItemsList +
                ", orderID=" + orderID +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", customerID=" + customerID +
                ", orderPhone=" + orderPhone +
                ", orderAddress=" + orderAddress +
                '}';
    }

    public List<OrderItem> getOrderItemsList() { return orderItemsList; }
}
