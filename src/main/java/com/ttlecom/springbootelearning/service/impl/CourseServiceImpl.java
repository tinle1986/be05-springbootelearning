package com.ttlecom.springbootelearning.service.impl;

import com.ttlecom.springbootelearning.dto.CourseDto;
import com.ttlecom.springbootelearning.entity.Course;
import com.ttlecom.springbootelearning.repository.CourseRepository;
import com.ttlecom.springbootelearning.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;

  public CourseServiceImpl(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  @Override
  public List<Course> getAll() {
    return courseRepository.findAll();
  }

  @Override
  public List<CourseDto> getAllDto() {
    return courseRepository.getAllDto();
  }

  @Override
  public Course getById(int id) {
    return courseRepository.findById(id).get();
  }

  @Override
  public Course getByTitle(String title) {
    return courseRepository.findByTitle(title);
  }

  @Override
  public void add(Course course) {
    Course entity = courseRepository.findByTitle(course.getTitle());
    if (entity == null) {
      courseRepository.save(course);
    } else {
      System.out.println("Course is existing!");
    }
  }

  @Override
  public void update(Course course) {
    Course entity = courseRepository.findById(course.getId()).get();
    entity.setLectureCount();
    entity.setHourCount();
    entity.setCategoryId(course.getCategoryId());
    entity.setContent(course.getContent());
    entity.setPrice(course.getPrice());
    entity.setDiscount(course.getDiscount());
    entity.setDescription(course.getDescription());
    entity.setImage(course.getImage());

    courseRepository.save(entity);
  }

  @Override
  public void delete(int id) {
    Course entity = courseRepository.findById(id).get();
    courseRepository.delete(entity);
  }
}
