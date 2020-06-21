package com.ttlecom.springbootelearning.service.impl;

import com.ttlecom.springbootelearning.entity.UserCourse;
import com.ttlecom.springbootelearning.repository.UserCourseRepository;
import com.ttlecom.springbootelearning.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public UserCourse getByUserId(int id) {
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
}
