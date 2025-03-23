package ProSale.manager;

import ProSale.AppLaunch;

import java.io.*;

public class SaveImageToResource {
    public String saveImageToResources(File sourceFile, String resourcePath) throws Exception {
        File directory = new File(resourcePath);
        if (!directory.exists()) {
            directory.mkdirs(); // Tạo thư mục nếu chưa tồn tại
        }

        String newFileName =  String.valueOf(AppLaunch.server.getIdManager().getCURRENT_IMAGE_ID()) +  ".png";

        File destinationFile = new File(resourcePath ,newFileName);
        try{
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile);

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                fos.close();
                fis.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return newFileName;
    }
}
