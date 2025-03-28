package ProSale.model.order;

import ProSale.AppLaunch;
import ProSale.model.product.Product;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private List<OrderItem> orderItemsList;
    private String orderTenNguoiNhan;
    private int orderID;
    private LocalDateTime orderDate;
    private String orderStatus;
    private int customerID;
    private String orderPhone;
    private String orderAddress;
    private String orderThanhToan;

    public String getOrderTenNguoiNhan() {
        return orderTenNguoiNhan;
    }

    public void setOrderTenNguoiNhan(String orderTenNguoiNhan) {
        this.orderTenNguoiNhan = orderTenNguoiNhan;
    }
    public Order(List<OrderItem> orderItemsList) throws Exception{
        this.orderItemsList = orderItemsList;
        orderID = AppLaunch.server.getIdManager().getCURRENT_ORDER_ID();
        orderStatus = "Chờ xác nhận";
        orderThanhToan = "Chưa thanh toán";
        customerID = AppLaunch.server.getPersonUsing().getId();
        orderDate =  LocalDateTime.now();

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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
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

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderThanhToan() {
        return orderThanhToan;
    }

    public void setOrderThanhToan(String orderThanhToan) {
        this.orderThanhToan = orderThanhToan;
    }

    public int getTotalPrice(){
        int total = 0;
        for(OrderItem orderItem : orderItemsList){
            Product product = AppLaunch.server.getProductMap().get(orderItem.getProductID());
            total += product.getPrice() * orderItem.getQuantity();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderItemsList=" + orderItemsList +
                ", orderTenNguoiNhan='" + orderTenNguoiNhan + '\'' +
                ", orderID=" + orderID +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", customerID=" + customerID +
                ", orderPhone='" + orderPhone + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderThanhToan='" + orderThanhToan + '\'' +
                '}';
    }

    public List<OrderItem> getOrderItemsList() { return orderItemsList; }
}
