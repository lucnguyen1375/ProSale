package ProSale;

import ProSale.model.product.BanPhan;
import ProSale.model.product.Product;

import java.util.HashMap;
import java.util.Map;

public class Demo {


    public static void main(String[] args) throws Exception {
        Map<Integer, Product> map = new HashMap<Integer, Product>();
        BanPhan banphan = new BanPhan("Bàn phấn 80 1 tầng Xám", 1400000, "80 1 tầng", "Gỗ Hương Xám", "0.8 m", "Hàng đẹp, chất lượng", 12);
        banphan.setSrcImg("/ProSale/images/product/banPhan/banPhan_80_1T_Xam.jpg");
        banphan.setId(1);
        map.put(banphan.getId(), banphan);
        int i = 1;
        System.out.println(map.get(i));
    }
}