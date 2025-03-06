package ProSale;

import ProSale.model.product.BanPhan;
import ProSale.model.product.Product;
import ProSale.model.product.TuGiay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadProduct {
    public static Product product;
    public static List<Product> listProduct = new ArrayList<>();
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/ProSale/data/product.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listProduct = (ArrayList<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (product instanceof BanPhan) {
            System.out.println("true");
        }
        for (Product p : listProduct) {
            System.out.println(p);
        }
    }


}
