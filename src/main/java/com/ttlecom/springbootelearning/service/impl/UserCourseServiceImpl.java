package com.ttlecom.springbootelearning.service.impl;

import com.ttlecom.springbootelearning.dto.CourseDto;
import com.ttlecom.springbootelearning.entity.UserCourse;
import com.ttlecom.springbootelearning.repository.CourseRepository;
import com.ttlecom.springbootelearning.repository.UserCourseRepository;
import com.ttlecom.springbootelearning.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class UserCourseServiceImpl implements UserCourseService {
  @Autowired
  private UserCourseRepository userCourseRepository;
  @Autowired
  private CourseRepository courseRepository;

  @Override
  public List<UserCourse> getAll() {
    return userCourseRepository.findAll();
  }

  @Override
  public List<UserCourse> getByUserId(int id) {
    return userCourseRepository.findByUserId(id);
  }

  @Override
  public List<CourseDto> getCourseListByUserId(int id) {
    List<Integer> courseIdList = getCourseIdByUserId(id);
    List<CourseDto> courseList = new ArrayList<>();
    courseIdList.forEach(courseId -> {
      courseList.add(courseRepository.getCourseDtoById(courseId));
    });
    return courseList;
  }

  @Override
  public void add(UserCourse userCourse) {
    List<UserCourse> userCourseList = userCourseRepository.findByUserId(userCourse.getUserId());
    AtomicBoolean userCourseExists = new AtomicBoolean(false);
    userCourseList.forEach(userCourseItem -> {
      System.out.println(userCourseItem.getCourseId());
      System.out.println(userCourse.getCourseId());
      if (userCourseItem.getCourseId() == userCourse.getCourseId()) {
        userCourseExists.set(true);
      }
    });
    System.out.println(userCourseExists.get());
    if (!userCourseExists.get()) {
      userCourseRepository.save(userCourse);
    } else {
      System.out.println("Course is existing!");
    }
  }

  @Override
  public List<Integer> getCourseIdByUserId(int id) {
    List<Integer> courseIdList = new ArrayList<>();
    List<UserCourse> userCourseList = userCourseRepository.findByUserId(id);
    userCourseList.forEach(userCourse -> {
      courseIdList.add(userCourse.getCourseId());
    });
    return courseIdList;
  }
}
