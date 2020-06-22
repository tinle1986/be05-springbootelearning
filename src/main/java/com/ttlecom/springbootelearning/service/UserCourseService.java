package com.ttlecom.springbootelearning.service;

import com.ttlecom.springbootelearning.entity.UserCourse;

import java.util.List;

public interface UserCourseService {
  List<UserCourse> getAll();
  List<UserCourse> getByUserId(int id);
  void add(UserCourse userCourse);
  List<Integer> getCourseIdByUserId(int id);
}
