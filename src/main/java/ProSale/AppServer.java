package ProSale;

import ProSale.model.person.User;
import ProSale.model.product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppServer {
    private List<User> userList;
    private User userUsing;
    private List<Product> productList;
    public AppServer() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/ProSale/data/user.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            userList = (ArrayList<User>) ois.readObject();
            fis = new FileInputStream("src/main/resources/ProSale/data/product.txt");
            ois = new ObjectInputStream(fis);
            productList = (ArrayList<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            //System.out.println("class not found");
            throw new RuntimeException(e);
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setUserUsing(User userUsing) {
        this.userUsing = userUsing;
    }

    public User getUserUsing() {return userUsing;}
}
