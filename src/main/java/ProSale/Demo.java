package ProSale;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        String path = "C:/Users/Username/Documents/project/file.txt";
        File file = new File(path);

        // Lấy thư mục cuối cùng
        String parentFolder = file.getParentFile().getName();
        System.out.println("parent folder: " + parentFolder);
        String fileName = file.getName();
        System.out.println("file name: " + fileName);
        // Kết quả dạng "project/file.txt"
        String shortPath = parentFolder + "/" + fileName;
        System.out.println(shortPath); // Kết quả: project/file.txt
    }
}
