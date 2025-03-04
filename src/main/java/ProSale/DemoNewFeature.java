package ProSale;

import ProSale.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DemoNewFeature {
    public static void main(String[] args) {
        User user1 = new User("luc123", "123456", "Luc", "Nam", "Ha Noi", "0369041397", "luchuubang@gmail.com");
        User user2 = new User("anh123", "123456","Anh", "Nu", "Nam Dinh", "0369041397", "anhtran@gmail.com");
        User user3 = new User("abc123", "123456","Luc", "Nam", "Ha Noi", "0369041397", "luchuubang@gmail.com");
        User user4 = new User("xyz123", "123456","Luc", "Nam", "Ha Noi", "0369041397", "luchuubang@gmail.com");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        try {
            FileOutputStream fos = new FileOutputStream("src/main/resources/ProSale/data/userData.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.writeObject(user4);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
