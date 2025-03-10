package ProSale;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ProSale.manager.IDManager;
import ProSale.model.person.User;

public class WriteProduct {
    public static void main(String[] args) throws Exception{
        List<User> users = new ArrayList<>();
        IDManager idManager = new IDManager();
        FileOutputStream fos = new FileOutputStream("src/main/resources/ProSale/data/id.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(idManager);
        oos.close();
        fos.close();
    }
}
