package ProSale;

import ProSale.manager.IDManager;

import java.io.*;

public class ReadProduct {
    public static IDManager idManager;
    public static void main(String[] args) {
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
