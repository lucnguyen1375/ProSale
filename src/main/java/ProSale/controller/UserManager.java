package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserManager {
    public boolean checkIfUsernameExists(String username) {
        for(User user: AppLaunch.server.getUserList()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfAccountRight(String username, String password) {
        for(User user: AppLaunch.server.getUserList()) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
                else return false;
            }
        }
        return false;
    }

    public User userUsing(String username, String password) {
        for(User user: AppLaunch.server.getUserList()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        AppLaunch.server.getUserList().add(user);
        try {
            FileOutputStream fis = new FileOutputStream("src/main/resources/ProSale/data/userData.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeObject(AppLaunch.server.getUserList());
            oos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
