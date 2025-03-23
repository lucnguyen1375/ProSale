package ProSale.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SaveImageToReSource {
    public String saveImageToResources(File sourceFile, String resourcePath) throws Exception {
        File directory = new File(resourcePath);
        if (!directory.exists()) {
            directory.mkdirs(); // Tạo thư mục nếu chưa tồn tại
        }
        IDManager idManager = new IDManager();
        String newFileName =  String.valueOf(idManager.getCURRENT_IMAGE_ID()) +  ".png";
        System.out.println(newFileName);// Đặt tên file mới
        File destinationFile = new File(resourcePath + newFileName);
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
        return newFileName;
    }
}
