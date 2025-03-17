package ProSale.model.product;

public class BanPhan extends Product{
    public BanPhan() {super();}
    public BanPhan(String name, int price, String type, String material, String size, String description, int quantity) throws Exception{
        super(name, price, type, material, size, description, quantity);
    }

}
