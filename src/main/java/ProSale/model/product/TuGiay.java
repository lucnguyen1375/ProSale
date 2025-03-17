package ProSale.model.product;

public class TuGiay extends Product{
    public TuGiay(){super();}
    public TuGiay(String name, int price, String type, String material, String size, String description, int quantity) throws Exception{
        super(name, price, type, material, size, description, quantity);
    }

}
