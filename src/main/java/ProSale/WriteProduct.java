package ProSale;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ProSale.manager.IDManager;
import ProSale.model.person.Admin;
import ProSale.model.person.Person;
import ProSale.model.person.User;

public class WriteProduct {
    public static void main(String[] args) throws Exception{
        List<Person> list = new ArrayList<>();
        Admin admin = new Admin("admin", "admin","Luc Nguyen", "Nam", "Ha Noi", "0369041397", "luchuubang@gmail.com");
        list.add(admin);
        IDManager idManager = new IDManager();
        FileOutputStream fos = new FileOutputStream("src/main/resources/ProSale/data/id.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(idManager);
        oos.close();
        fos.close();
    }
}
