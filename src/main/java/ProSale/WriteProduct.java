package ProSale;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ProSale.model.product.*;

public class WriteProduct {
    public static void main(String[] args) {
        Product product = new Product();
        TuGiay tuGiay = new TuGiay("Tủ giày 80 Hương Xám Lừng Nan", 1400000, "Lửng Nan", "Gỗ Hương Xám", "0.8m", "Hàng đẹp, chất lượng", 12);
        tuGiay.setSrcImg("/ProSale/images/product/tuGiay/80_huongxam_lung_nan.png");

        BanPhan banPhan = new BanPhan("Bàn phấn một tầng Hương Xám", 1300000, "1 Tầng", "Gỗ Hương Xám", "0.8m", "Hàng đẹp, chất lượng", 12);
        banPhan.setSrcImg("/ProSale/images/product/banPhan/banPhan_80_1T_Xam.jpg");

        Guong guong = new Guong("Thiên Nga Hương Xám", 500000, "Thiên Nga", "Gỗ Hương Xám", "0.5m", "Hàng đẹp, chất lượng", 12);
        guong.setSrcImg("/ProSale/images/product/guong/guong_thienNga_xam.jpg");

        Ghe ghe = new Ghe("Ghế Hương Xám", 200000, "Ghế", "Gỗ Hương Xám", "0.5m", "Hàng đẹp, chất lượng", 12);
        ghe.setSrcImg("/ProSale/images/product/ghe/ghe_xam.jpg");
        TuDauGiuong tuDauGiuong = new TuDauGiuong("Tủ Đầu Giường Hương Xám", 800000, "Tủ Đầu Giường", "Gỗ Hương Xám", "0.6m", "Hàng đẹp, chất lượng", 12);
        tuDauGiuong.setSrcImg("/ProSale/images/product/tuDauGiuong/tap_BoGiua_Xam.jpg");

        List<Product> listProduct = new ArrayList<>();
        listProduct.add(tuGiay);
        listProduct.add(banPhan);
        listProduct.add(ghe);
        listProduct.add(guong);
        listProduct.add(tuDauGiuong);

        try {
            FileOutputStream fos = new FileOutputStream("src/main/resources/ProSale/data/product.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listProduct);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
