package ProSale;

import ProSale.manager.IOSystem;
import ProSale.model.person.Person;
import ProSale.model.person.User;
import ProSale.model.product.Product;
import ProSale.manager.IDManager;

import java.util.List;

public class AppServer {
    private IDManager idManager;
    private List<User> userList;
    private User userUsing;
    private Person personUsing;

    public Person getPersonUsing() {
        return personUsing;
    }

    public void setPersonUsing(Person personUsing) {
        this.personUsing = personUsing;
    }

    private List<Product> productList;
    private List<Person> personList;

    public AppServer() {
    }

    public void setUserUsing(User userUsing) {
        this.userUsing = userUsing;
    }
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    public void setIdManager(IDManager idManager) {
        this.idManager = idManager;
    }
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    public void setPersonList(List<Person> personList) {this.personList = personList;}
    public List<User> getUserList() {
        return userList;
    }
    public List<Product> getProductList() {return productList;}
    public User getUserUsing() {return userUsing;}
    public IDManager getIdManager() {
        return idManager;
    }
    public List<Person> getPersonList() {return personList;}
}
