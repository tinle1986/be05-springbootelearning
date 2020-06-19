package com.ttlecom.springbootelearning.api.controller;

import com.ttlecom.springbootelearning.entity.Video;
import com.ttlecom.springbootelearning.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/video")
public class ApiVideoController {

  @Autowired
  private VideoService videoService;

  @GetMapping("{id}")
  public ResponseEntity<?> getVideoByCourseId(@PathVariable int id) {
    try {
      List<Video> videoList = videoService.getAllByCourseId(id);
      return new ResponseEntity<List<Video>>(videoList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
