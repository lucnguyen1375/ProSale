package ProSale;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ProSale.model.order.Order;
import ProSale.model.order.OrderItem;
import ProSale.model.person.UserWithOrder;
import ProSale.model.product.*;

public class WriteProduct {
    public static void main(String[] args) {
        Product product = new Product();
        try {
            FileOutputStream fos = new FileOutputStream("src/main/resources/ProSale/data/demo.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(product);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
