package ProSale.model;

import java.io.Serializable;

public class User extends Person{

    public User(){};

    public User(String name, int age, String gender, String address, String phone, String email) {
        super(name, age, gender, address, phone, email);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
