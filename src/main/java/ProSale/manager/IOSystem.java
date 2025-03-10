package ProSale.manager;

import ProSale.AppLaunch;
import ProSale.AppServer;
import ProSale.model.person.User;
import ProSale.model.product.Product;

import java.io.*;
import java.util.ArrayList;

public class IOSystem {
    private static FileOutputStream fos;
    private static FileInputStream fis;
    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;

    public IOSystem() {}

    public static void saveUserData() throws Exception {
        fos = new FileOutputStream("src/main/resources/ProSale/data/user.txt");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(AppLaunch.server.getUserList());
        oos.close();
        fos.close();
    }

    public static void saveProductData() throws Exception {
        fos = new FileOutputStream("src/main/resources/ProSale/data/product.txt");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(AppLaunch.server.getProductList());
        oos.close();
        fos.close();
    }

    public static void saveIDData() throws Exception {
        fos = new FileOutputStream("src/main/resources/ProSale/data/id.txt");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(AppLaunch.server.getIdManager());
        oos.close();
        fos.close();
    }

    public static void loadData(AppServer server) throws Exception {
        fis = new FileInputStream("src/main/resources/ProSale/data/user.txt");
        ois = new ObjectInputStream(fis);
        server.setUserList((ArrayList<User>)ois.readObject());

        fis = new FileInputStream("src/main/resources/ProSale/data/product.txt");
        ois = new ObjectInputStream(fis);
        server.setProductList((ArrayList<Product>)ois.readObject());

        fis = new FileInputStream("src/main/resources/ProSale/data/id.txt");
        ois = new ObjectInputStream(fis);
        server.setIdManager((IDManager) ois.readObject());
        ois.close();
        fis.close();
    }

}
