package com.ttlecom.springbootelearning.service.impl;

import com.ttlecom.springbootelearning.entity.UserCourse;
import com.ttlecom.springbootelearning.repository.UserCourseRepository;
import com.ttlecom.springbootelearning.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {
  @Autowired
  private UserCourseRepository userCourseRepository;

  @Override
  public List<UserCourse> getAll() {
    return userCourseRepository.findAll();
  }

  @Override
  public List<UserCourse> getByUserId(int id) {
    return userCourseRepository.findByUserId(id);
  }

  @Override
  public void add(UserCourse userCourse) {
    UserCourse entity = userCourseRepository.findByCourseId(userCourse.getCourseId());
    if (entity == null) {
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
