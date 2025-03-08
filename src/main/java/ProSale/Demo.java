package ProSale;

import java.text.DecimalFormat;

public class Demo {
    public static void main(String[] args) {
        int number = 123456789;
        double decimal = 1234567.89;

        DecimalFormat df = new DecimalFormat("#,###");
        String st = df.format(number);

        System.out.println(st);
//        System.out.println(df.format(number));     // Output: 123,456,789
//        System.out.println(df2.format(decimal));   // Output: 1,234,567.89
    }
}