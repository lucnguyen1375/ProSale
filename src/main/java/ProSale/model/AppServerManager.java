package ProSale.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class AppServerManager {
    public void Init() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/ProSale/data/userData.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<User> list = new ArrayList<>();
            while(true){
                User user = (User)ois.readObject();
                if (user == null) break;
                System.out.println(user);
                list.add(user);
            }


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
