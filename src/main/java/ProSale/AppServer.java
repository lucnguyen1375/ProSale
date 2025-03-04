package ProSale;

import ProSale.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppServer {
    private List<User> userList;
    private User user;

    public AppServer() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/ProSale/data/userData.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            userList = (ArrayList<User>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
