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
    public static List<Person> list1;
    public static IDManager idManager;
    public static void main(String[] args) {
        list = new ArrayList<Product>();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/ProSale/data/person.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list1 = (ArrayList<Person>) ois.readObject();
            System.out.println(list1);
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
