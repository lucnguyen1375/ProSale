package ProSale.model.product;

import java.io.Serializable;

public class Product implements Serializable {
    protected String name;
    protected String srcImg;
    protected int price;
    protected String type;
    protected String material;
    protected String size;
    protected String description;
    protected int quantity;
//    protected int saleQuantity;
//
//
//    public void setSaleQuantity(int saleQuantity) {
//        this.saleQuantity = saleQuantity;
//    }
//
//    public int getSaleQuantity() {
//        return saleQuantity;
//    }

    public Product() {}

    public Product(String name, int price, String type, String material, String size, String description, int quantity) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.material = material;
        this.size = size;
        this.description = description;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSrcImg(String srcImg) {
        this.srcImg = srcImg;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getSrcImg() {
        return srcImg;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", srcImg='" + srcImg + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", material='" + material + '\'' +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
