package ProSale.controller;

import ProSale.manager.IOSystem;
import ProSale.model.product.Product;

public class ProductManager {
    public void addProductQuantity(Product product, int quantity) {
        product.setQuantity(product.getQuantity() + quantity);
    }

}
