package ProSale.model.product;

public class TuDauGiuong extends Product{
    public TuDauGiuong() {super();}
    public TuDauGiuong(String name, int price, String type, String material, String size, String description, int quantity) throws Exception{
        super(name, price, type, material, size, description, quantity);
    }
}
