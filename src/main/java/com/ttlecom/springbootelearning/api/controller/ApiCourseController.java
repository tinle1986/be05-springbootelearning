package com.ttlecom.springbootelearning.api.controller;

import com.ttlecom.springbootelearning.dto.CourseCartDto;
import com.ttlecom.springbootelearning.dto.CourseDto;
import com.ttlecom.springbootelearning.entity.User;
import com.ttlecom.springbootelearning.entity.UserCourse;
import com.ttlecom.springbootelearning.security.CustomUserDetails;
import com.ttlecom.springbootelearning.service.CourseService;
import com.ttlecom.springbootelearning.service.UserCourseService;
import com.ttlecom.springbootelearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("api/course")
public class ApiCourseController {

  @Autowired
  private CourseService courseService;
  @Autowired
  private UserService userService;
  @Autowired
  private UserCourseService userCourseService;

  // get a course detail
  @GetMapping("detail/{id}")
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

  // get cart list
  @PostMapping("cart")
  public ResponseEntity<?> addCart(@RequestBody CourseCartDto courseCartDto) {
    try {
      List<CourseDto> courseCartList = new LinkedList<>();
      courseService.getAll().forEach(course -> {
        courseCartDto.getCartList().forEach(courseId -> {
          if (courseId == course.getId()) {
            CourseDto entity = courseService.getDtoById(courseId);
            courseCartList.add(entity);
          }
        });
      });
      return new ResponseEntity<List<CourseDto>>(courseCartList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  // get course IDs bought of specific user
  @GetMapping("purchase/bought")
  public ResponseEntity<?> getBoughtCourses() {
    try {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      CustomUserDetails customUserDetails = (CustomUserDetails) principal;
      String email = customUserDetails.getUsername();
      User userEntity = userService.getByEmail(email);
      int userId = userEntity.getId();
      List<Integer> courseIdList = userCourseService.getCourseIdByUserId(userId);
      return new ResponseEntity<List<Integer>>(courseIdList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  // buy now for one course or multiple courses
  @PostMapping("purchase")
  public ResponseEntity<?> buyOne(@RequestBody CourseCartDto courseCartDto) {
    try {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = (UserDetails) principal;
      String email = userDetails.getUsername();
      User entity = userService.getByEmail(email);
      int userId = entity.getId();
      courseCartDto.getCartList().forEach(courseId -> {
        System.out.println(courseId);
        UserCourse userCourseEntity = new UserCourse();
        userCourseEntity.setUserId(userId);
        userCourseEntity.setCourseId(courseId);
        userCourseEntity.setRoleId(entity.getRoleId());
        userCourseService.add(userCourseEntity);
      });
      return new ResponseEntity<String>("Purchased successfully", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
