package ProSale.model.person;

import java.io.Serializable;
import java.util.List;

import ProSale.model.order.*;

public class UserWithOrder extends Person implements Serializable {
    private List<Order> orderList;
    private Order gioHang;

    public UserWithOrder(){};

    public UserWithOrder(String name, String gender, String address, String phone, String email) {
        super(name, gender, address, phone, email);
    }
    public UserWithOrder(String username, String password, String name, String gender, String address, String phone, String email) {
        super(username, password, name, gender, address, phone, email);
    }
    @Override
    public String toString() {
        return "UserWithOrder{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", orderList=" + orderList +
                ", gioHang=" + gioHang +
                '}';
    }
    public List<Order> getOrderList() { return orderList; }
    public void setOrderList(List<Order> orderList) { this.orderList = orderList; }
    public Order getGioHang() { return gioHang; }
    public void setGioHang(Order gioHang) { this.gioHang = gioHang; }
}
