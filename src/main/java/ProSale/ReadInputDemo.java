package ProSale;

import ProSale.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadInputDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/ProSale/data/userData.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            var resultList = (ArrayList<User>) ois.readObject();
            for (var user : resultList) {
                System.out.println(user);
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
}
