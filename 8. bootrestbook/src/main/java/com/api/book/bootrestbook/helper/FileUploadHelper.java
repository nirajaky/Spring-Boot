package com.api.book.bootrestbook.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR = "D:\\Code & Application\\Basic Codes\\Spring Boot\\bootrestbook\\src\\main\\resources\\static\\images";

    public boolean uploadFile(MultipartFile multipartFile){
        boolean f = false;

        try{
//            // Read file
//            InputStream is = multipartFile.getInputStream();
//            byte data[] = new byte[is.available()];      // gets the size of file getting in bytes
//            is.read(data);              // reads the byte data
//
//            // write file
//                        // Directory with file name where file is going to be saved
//            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename() );
//            fileOutputStream.write(data);
//            fileOutputStream.flush();
//            fileOutputStream.close();
//            f=true;

            //          ALTERNATIVE
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;
        }catch(Exception e){
            e.printStackTrace();
        }

        return f;
    }
}
