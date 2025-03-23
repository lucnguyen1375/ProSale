package ProSale;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ProSale.manager.IDManager;
import ProSale.model.order.Order;
import ProSale.model.person.Admin;
import ProSale.model.person.Person;
import ProSale.model.product.*;

public class WriteProduct {

    public static void main(String[] args) throws Exception{
        List<Product> productList = new ArrayList<>();
        BanPhan banphan = new BanPhan("Bàn phấn 80 1 tầng Xám", 1400000, "80 1 tầng", "Gỗ Hương Xám", "0.8 m", "Hàng đẹp, chất lượng", 12);
        banphan.setSrcImg("/ProSale/images/product/banPhan/banPhan_80_1T_Xam.jpg");
        banphan.setId(1);
        Ghe ghe = new Ghe("Ghế Hương Xám", 100000, "Ghế", "Gỗ Hương Xám", "0.4 m", "Hàng đẹp, chất lượng", 12);
        ghe.setSrcImg("/ProSale/images/product/ghe/ghe_xam.jpg");
        ghe.setId(2);
        TuGiay tuGiay = new TuGiay("Tủ giày 80 Lửng Nan Xám", 1600000, "Bo Lửng Nan", "Gỗ Hương Xám", "0.8m", "Hàng đẹp, chất lượng", 12);
        tuGiay.setSrcImg("/ProSale/images/product/tuGiay/80_huongxam_lung_nan.png");
        tuGiay.setId(3);
        TuDauGiuong tuDauGiuong = new TuDauGiuong("Táp Bo Giữa Xám", 800000, "Táp Bo Giữa", "Gỗ Hương Xám", "0.8m", "Hàng đẹp, chất lượng", 12);
        tuDauGiuong.setSrcImg("/ProSale/images/product/tuDauGiuong/tap_BoGiua_Xam.jpg");
        tuDauGiuong.setId(4);
        Guong guong = new Guong("Gương Thiên nga Xám", 400000, "Gương", "Gỗ Hương Xám", "0.6m", "Hàng đẹp, chất lượng", 12);
        guong.setSrcImg("/ProSale/images/product/guong/guong_thienNga_xam.jpg");
        guong.setId(5);
        productList.add(banphan);
        productList.add(ghe);
        productList.add(tuGiay);
        productList.add(tuDauGiuong);
        productList.add(guong);

        List<Person> personList = new ArrayList<>();
        Admin admin = new Admin("admin", "admin", "Luc Nguyen", "Nam", "Ha Noi", "0369041397", "admin");
        personList.add(admin);
        IDManager idManager = new IDManager();

        Order order = new Order();
        List<Order> orderList = new ArrayList<>();

        FileOutputStream fos = new FileOutputStream("src/main/resources/ProSale/data/person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(personList);

        fos = new FileOutputStream("src/main/resources/ProSale/data/product.txt");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(productList);

        fos = new FileOutputStream("src/main/resources/ProSale/data/order.txt");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(orderList);

        fos = new FileOutputStream("src/main/resources/ProSale/data/id.txt");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(idManager);

        oos.close();
        fos.close();
    }
}
