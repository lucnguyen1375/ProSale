package ProSale;

import ProSale.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DemoNewFeature {
    public static void main(String[] args) {
        User user1 = new User("Luc", 19, "Nam", "Ha Noi", "0369041397", "luchuubang@gmail.com");
        User user2 = new User("Anh", 19, "Nu", "Nam Dinh", "0369041397", "anhtran@gmail.com");
        User user3 = new User("Luc", 19, "Nam", "Ha Noi", "0369041397", "luchuubang@gmail.com");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        try {
            FileOutputStream fos = new FileOutputStream("src/main/resources/ProSale/data/userData.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(User user : list) {
                oos.writeObject(user);
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
