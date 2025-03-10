package ProSale.model.person;

import java.io.Serializable;

public class User extends Person implements Serializable {
    public User(){};

    public User(String name, String gender, String address, String phone, String email) {
        super(name, gender, address, phone, email);
    }
    public User(String username, String password, String name, String gender, String address, String phone, String email) {
        super(username, password, name, gender, address, phone, email);
    }
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
                '}';
    }
}
