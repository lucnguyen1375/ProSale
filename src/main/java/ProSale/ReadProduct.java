package ProSale;

import ProSale.manager.IDManager;
import ProSale.model.person.Admin;
import ProSale.model.person.Person;
import ProSale.model.product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadProduct {
    public static List<Product> list;
    public static IDManager idManager;
    public static void main(String[] args) {
        list = new ArrayList<Product>();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/ProSale/data/product.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Product>) ois.readObject();
            System.out.println(list);
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
