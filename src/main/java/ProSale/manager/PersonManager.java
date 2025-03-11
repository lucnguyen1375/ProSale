package ProSale.manager;

import ProSale.AppLaunch;
import ProSale.model.person.Person;
import ProSale.model.person.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersonManager {
    public boolean checkIfUsernameExists(String username) {
        for(Person person: AppLaunch.server.getPersonList()) {
            if (person.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfAccountRight(String username, String password) {
        for(Person person: AppLaunch.server.getPersonList()) {
            if (person.getUsername().equals(username)) {
                if (person.getPassword().equals(password)) {
                    return true;
                }
                else return false;
            }
        }
        return false;
    }

    public Person personUsing(String username, String password) {
        for(Person person: AppLaunch.server.getPersonList()) {
            if (person.getUsername().equals(username) && person.getPassword().equals(password)) {
                return person;
            }
        }
        return null;
    }

    public void savePerson(Person person) {
        AppLaunch.server.getPersonList().add(person);
        try {
            FileOutputStream fis = new FileOutputStream("src/main/resources/ProSale/data/person.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeObject(AppLaunch.server.getPersonList());
            oos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
