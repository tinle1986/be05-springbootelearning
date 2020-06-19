package com.ttlecom.springbootelearning.api.controller;

import com.ttlecom.springbootelearning.dto.CourseDto;
import com.ttlecom.springbootelearning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/course")
public class ApiCourseController {

  @Autowired
  private CourseService courseService;

  // get a course detail
  @GetMapping("{id}")
  public ResponseEntity<?> getDetails(@PathVariable int id) {
    try {
      CourseDto entity = courseService.getDtoById(id);
      return new ResponseEntity<CourseDto>(entity, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  // get all courseDto
  @GetMapping("list")
  public ResponseEntity<?> getAllDto() {
    try {
      List<CourseDto> courseDtoList = courseService.getAllDto();
      return new ResponseEntity<List<CourseDto>>(courseDtoList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
