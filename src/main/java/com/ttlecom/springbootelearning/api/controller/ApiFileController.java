package com.ttlecom.springbootelearning.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("api/file")
public class ApiFileController {

  @Value("${file.upload-dir}")
  private String uploadFolder;

  @Value("${file.upload-return-dir}")
  private String returnFolder;

  @PostMapping("upload")
  public ResponseEntity<? extends Object> upload(@RequestBody MultipartFile file) {
    try {
      String fileName = file.getOriginalFilename().replace(" ", "_");
      String rootPath = System.getProperty("user.dir");

//      System.out.println("rootPath: " + rootPath);

      String imgFolderPath = rootPath + uploadFolder;
//      System.out.println("imgFolderPath: " + imgFolderPath);

      File imgFolder = new File(imgFolderPath);
      if (!imgFolder.exists()) {
        imgFolder.mkdir();
      }

      File filePath = new File(imgFolderPath + fileName);
//      System.out.println("filePath: " + filePath);
      file.transferTo(filePath);

      String returnPath = returnFolder + fileName;
      System.out.println(returnPath);

      return new ResponseEntity<String>(returnPath, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
