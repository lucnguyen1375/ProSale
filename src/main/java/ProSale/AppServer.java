package ProSale;

import ProSale.manager.IOSystem;
import ProSale.model.order.Order;
import ProSale.model.person.Person;
import ProSale.model.person.User;
import ProSale.model.product.Product;
import ProSale.manager.IDManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppServer {
    private IDManager idManager;
    private Person personUsing;
    private List<Order> orderList;
    private List<Product> productList;
    private List<Person> personList;
    private Map<Integer, Product> productMap;
    private Map<Integer, Order> orderMap;
    private Map<Integer, Person> personMap;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void setProductMap(Map<Integer, Product> productMap) {
        this.productMap = productMap;
    }

    public Map<Integer, Order> getOrderMap() {
        return orderMap;
    }

    public Map<Integer, Person> getPersonMap() {
        return personMap;
    }

    public void setMap(){
        setProductMap();
        setOrderMap();
        setPersonMap();
    }
    public void setProductMap() {
        this.productMap = new HashMap<Integer, Product>();
        for (Product product : this.productList) {
            this.productMap.put(product.getId(), product);
        }
    }
    public void setOrderMap() {
        this.orderMap = new HashMap<Integer, Order>();
        for(Order order : this.orderList) {
            this.orderMap.put(order.getOrderID(), order);
        }
    }
    public void setPersonMap() {
        this.personMap = new HashMap<Integer, Person>();
        for(Person person : this.personList) {
            this.personMap.put(person.getId(), person);
        }
    }

    public Person getPersonUsing() {
        return personUsing;
    }

    public void setPersonUsing(Person personUsing) {
        this.personUsing = personUsing;
    }


    public AppServer() {}

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public void setIdManager(IDManager idManager) {
        this.idManager = idManager;
    }
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    public void setPersonList(List<Person> personList) {this.personList = personList;}

    public List<Product> getProductList() {return productList;}
    public IDManager getIdManager() {
        return idManager;
    }
    public List<Person> getPersonList() {return personList;}
}
