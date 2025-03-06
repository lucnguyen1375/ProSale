package ProSale.model.person;

import java.io.Serializable;

public class Admin extends Person implements Serializable {
    public Admin(String name, String gender, String address, String phone, String email) {
        super(name, gender, address, phone, email);
    }
}
