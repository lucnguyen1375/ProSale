package ProSale.manager;

import ProSale.model.product.Product;

import java.util.List;

public class ProductManager {
    public void addProductQuantity(Product product, int quantity) {
        product.setQuantity(product.getQuantity() + quantity);
    }

    public void sortProductsBySale(List<Product> products) {
        products.sort((p1, p2) -> p1.getQuantity() - p2.getQuantity());
    }
}
