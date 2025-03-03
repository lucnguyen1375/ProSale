package ProSale.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;


public class GuestOrder {
    private List<Pair<String, Integer>> listOrder;

    public GuestOrder() {
        listOrder = new ArrayList<>();
    }

    public void addProductOrder(Pair<String, Integer> product) {
        listOrder.add(product);
    }

    public void removeProductOrder(Pair<String, Integer> product) {
        listOrder.remove(product);
    }
    public List<Pair<String, Integer>> getListOrder() {
        return listOrder;
    }
}
