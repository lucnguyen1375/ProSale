package ProSale.model.person;

import ProSale.model.order.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends Person implements Serializable {
    private List<Order> orderList;
    private Order gioHang;

    public User(){};

    public User(String name, String gender, String address, String phone, String email) {
        super(name, gender, address, phone, email);
    }
    public User(String username, String password, String name, String gender, String address, String phone, String email) {
        super(username, password, name, gender, address, phone, email);
        gioHang = new Order();
        orderList = new ArrayList<Order>();
    }

    public void setOrderList(List<Order> orderList) { this.orderList = orderList; }
    public void setGioHang(Order gioHang) { this.gioHang = gioHang; }

    public Order getGioHang() { return gioHang;}
    public List<Order> getOrderList() { return orderList; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
}
