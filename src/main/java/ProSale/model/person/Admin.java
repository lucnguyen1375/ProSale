package ProSale.model.person;

import java.io.Serializable;

public class Admin extends Person implements Serializable{

    public Admin() {super();}
    public Admin(String name, String gender, String address, String phone, String email) {
        super(name, gender, address, phone, email);
    }
    public Admin(String username, String password, String name, String gender, String address, String phone, String email) throws Exception{
        super(username, password, name, gender, address, phone, email);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
