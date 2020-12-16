package com.api.book.bootrestbook.controllers;

import com.api.book.bootrestbook.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/file-upload")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file)throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getBytes());
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());

        try{
            if (file.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please Select a file");
            }
            if(!(file.getContentType().equals("image/jpeg"))){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please select a valid file");
            }
            // File upload code
            boolean b = fileUploadHelper.uploadFile(file);
            if(b == true){
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bad File Type");
    }
}
