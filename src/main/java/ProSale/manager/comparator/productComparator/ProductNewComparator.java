package ProSale.manager.comparator.productComparator;

import ProSale.model.product.Product;

import java.util.Comparator;

public class ProductNewComparator implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        return p2.getId() - p1.getId();
    }
}
