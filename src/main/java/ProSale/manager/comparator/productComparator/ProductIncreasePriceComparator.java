package ProSale.manager.comparator.productComparator;

import ProSale.model.product.Product;

import java.util.Comparator;

public class ProductIncreasePriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
