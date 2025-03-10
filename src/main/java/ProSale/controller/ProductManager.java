package ProSale.controller;

import ProSale.model.product.Product;

public class ProductManager {
    public void addProductQuantity(Product product, int quantity) {
        product.setQuantity(product.getQuantity() + quantity);
    }

    public void saveProduct(Product product) {

    }
}
