package utils;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Component
public class FileUpload {
    public final String IMG_URL = "/assets/img/";

    @Autowired
    private ServletContext servletContext;

    public void validateImage(MultipartFile image) {
        if(!image.getContentType().equals("image/jpeg")) {
            throw new ImageUploadException("Only JPG images accepted");
        }
    }

    public void saveImage(String filename, MultipartFile image){
        try {
            String webRootPath = servletContext.getRealPath("/WEB-INF");
            File file = new File(webRootPath + filename);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            throw new ImageUploadException("Upload was not successful!");
        }
    }
}
