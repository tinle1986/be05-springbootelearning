package com.ttlecom.springbootelearning.service;

import com.ttlecom.springbootelearning.dto.CourseDto;
import com.ttlecom.springbootelearning.entity.Course;

import java.util.List;

public interface CourseService {
  List<Course> getAll();

  List<CourseDto> getAllDto();

  Course getById(int id);

  Course getByTitle(String title);

  CourseDto getDtoById(int id);

  void add(Course course);

  void update(Course course);

  void delete(int id);
}
