package com.ttlecom.springbootelearning.service;

import com.ttlecom.springbootelearning.entity.UserCourse;

import java.util.List;

public interface UserCourseService {
  List<UserCourse> getAll();
  UserCourse getByUserId(int id);
  void add(UserCourse userCourse);
}
