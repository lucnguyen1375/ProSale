package ProSale;

import ProSale.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppServer {
    private List<User> userList;
    User user;
    public AppServer() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/ProSale/data/userData.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                //if (ois.available()<=0){break;}
                User user = (User)ois.readObject();
                if (user == null) break;
                System.out.println(user);
                userList.add(user);
            }
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
}
