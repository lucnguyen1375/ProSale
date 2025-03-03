package ProSale.Model;

public class Person {
    protected int username;
    protected String password;
    protected String name;
    protected int age;
    protected String gender;
    protected String address;
    protected String phone;
    protected String email;

    public Person() {}
    public Person(String name, int age, String gender, String address, String phone, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public int getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
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
}
