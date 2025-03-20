package ProSale.manager.comparator.productComparator;

import ProSale.model.product.Product;

import java.util.Comparator;

public class ProductDecreasePriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getPrice() - o1.getPrice();
    }
}
