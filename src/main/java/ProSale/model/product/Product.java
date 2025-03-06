package ProSale.model.product;

public class Product {
    protected String name;
    protected String srcImg;
    protected int price;
    protected String type;
    protected String material;
    protected String size;
    protected String description;
    protected int quantity;
    public Product() {}
    public Product(String name, int price, String type, String material, String size, String description, int quantity) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.material = material;
        this.size = size;
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
}
