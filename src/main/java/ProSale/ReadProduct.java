package ProSale;

import ProSale.manager.IDManager;
import ProSale.model.person.Admin;
import ProSale.model.person.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadProduct {
    public static List<Person> list;
    public static IDManager idManager;
    public static void main(String[] args) {
        list = new ArrayList<Person>();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/ProSale/data/id.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            idManager = (IDManager) ois.readObject();
            System.out.println(idManager);
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
