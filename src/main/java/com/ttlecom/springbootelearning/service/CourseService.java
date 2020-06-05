package com.ttlecom.springbootelearning.service;

import com.ttlecom.springbootelearning.entity.Course;

import java.util.List;

public interface CourseService {
  List<Course> getAll();

  Course getById(int id);

  Course getByTitle(String title);

  void add(Course course);

  void update(Course course);

  void delete(int id);
}
