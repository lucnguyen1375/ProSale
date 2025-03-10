package ProSale;

import ProSale.model.person.User;
import ProSale.model.person.UserWithOrder;
import ProSale.model.product.BanPhan;
import ProSale.model.product.Product;
import ProSale.model.product.TuGiay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadProduct {
    public static User user;
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/ProSale/data/demo.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            user = (User)ois.readObject();
            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(user);
    }


}
