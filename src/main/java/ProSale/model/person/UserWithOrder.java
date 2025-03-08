package ProSale.model.person;

import ProSale.model.UserOrder;

import java.io.Serializable;

public class UserWithOrder extends Person implements Serializable {
    private UserOrder order;

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
                ", order=" + order +
                '}';
    }
}
