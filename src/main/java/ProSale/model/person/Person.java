package ProSale.model.person;

import ProSale.AppLaunch;

import java.io.Serializable;

public class Person implements Serializable {
    protected String username;
    protected String password;
    protected String name;
    protected String gender;
    protected String address;
    protected String phone;
    protected String email;
    protected int id;

    public Person() {}
    public Person(String name, String gender, String address, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Person(String username, String password, String name, String gender,
                  String address, String phone, String email)
                                                                throws Exception
    {
//        id = AppLaunch.server.getIdManager().getCURRENT_USER_ID();
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() { return password; }
    public int getId() { return id; }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
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
