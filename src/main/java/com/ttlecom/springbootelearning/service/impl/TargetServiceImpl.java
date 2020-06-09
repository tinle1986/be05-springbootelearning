package com.ttlecom.springbootelearning.service.impl;

import com.ttlecom.springbootelearning.entity.Target;
import com.ttlecom.springbootelearning.repository.TargetRepository;
import com.ttlecom.springbootelearning.service.CourseService;
import com.ttlecom.springbootelearning.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetServiceImpl implements TargetService {

  @Autowired
  private TargetRepository targetRepository;
  @Autowired
  private CourseService courseService;

  @Override
  public List<Target> getAll() {
    return targetRepository.findAll();
  }

  @Override
  public List<Target> findByCourseId(int id) {
    return targetRepository.findTargetByCourseId(id);
  }

  @Override
  public Target getById(int id) {
    return targetRepository.findById(id).get();
  }

  @Override
  public void add(Target target) {
    targetRepository.save(target);

    // find courseId to make targetList and update targetList into the course
//    Course entity = courseService.getById(target.getId());
//    List<Target> targetList = targetRepository.findTargetByCourseId(entity.getId());
//    entity.setTargetList(targetList);
//    courseService.update(entity);
  }

  @Override
  public void update(Target target) {
    Target entity = targetRepository.findById(target.getId()).get();
    entity.setTitle(target.getTitle());
    entity.setCourseId(target.getCourseId());
    targetRepository.save(entity);

//    Course course = courseService.getById(target.getId());
//    List<Target> targetList = targetRepository.findTargetByCourseId(course.getId());
//    course.setTargetList(targetList);
//    courseService.update(course);
  }

  @Override
  public void delete(int id) {
    targetRepository.deleteById(id);
  }
}
