package com.ttlecom.springbootelearning.service;

import com.ttlecom.springbootelearning.dto.CourseDto;
import com.ttlecom.springbootelearning.entity.Course;

import java.util.List;

public interface CourseService {
  List<Course> getAll();

  List<CourseDto> getAllDto();

  List<Course> getByCategoryId(int id);

  Course getById(int id);

  List<Course> getCoursesByTitleContaining(String title);

  CourseDto getDtoById(int id);

  void add(Course course);

  void update(Course course);

  void delete(int id);
}
