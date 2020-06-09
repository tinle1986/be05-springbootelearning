package com.ttlecom.springbootelearning.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;

@Controller
@RequestMapping("admin/image")
public class AdminImageController {

  // /src/main/resources/static/assets/upload/images/
  @Value("${file.img-upload-dir}")
  private String uploadFolder;

  // /assets/upload/images/
  @Value("${file.img-upload-return-dir}")
  private String returnFolder;

  @PostMapping("upload")
  public ResponseEntity<?> singleFileUpload(@RequestParam("file") MultipartFile file) {
    try {
      String fileName = Objects.requireNonNull(file.getOriginalFilename()).replace(" ", "_");
      String rootPath = System.getProperty("user.dir");
      String imgFolderPath = rootPath + uploadFolder;

      File imgFolder = new File(imgFolderPath);
      if(!imgFolder.exists()) {
        imgFolder.mkdir();
      }

      File filePath = new File(imgFolderPath + fileName);
      file.transferTo(filePath);

      String returnPath = returnFolder + fileName;
      return new ResponseEntity<String>(returnPath, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
