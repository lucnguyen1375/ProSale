package ProSale.manager.comparator.productComparator;

import ProSale.model.product.Product;

import java.util.Comparator;

public class ProductSaleComparator implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        return p1.getSaleQuantity() - p2.getSaleQuantity();
    }
}
