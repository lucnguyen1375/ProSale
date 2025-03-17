package ProSale.model.person;

import ProSale.model.order.GioHang;
import ProSale.model.order.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends Person implements Serializable {
    private List<Order> orderList;
    private GioHang gioHang;

    public User(){};

    public User(String name, String gender, String address, String phone, String email) {
        super(name, gender, address, phone, email);
    }
    public User(String username, String password, String name, String gender, String address, String phone, String email) throws Exception{
        super(username, password, name, gender, address, phone, email);
        gioHang = new GioHang();
        orderList = new ArrayList<Order>();
    }

    public void setOrderList(List<Order> orderList) { this.orderList = orderList; }
    public void setGioHang(GioHang gioHang) { this.gioHang = gioHang; }

    public GioHang getGioHang() { return gioHang;}
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
