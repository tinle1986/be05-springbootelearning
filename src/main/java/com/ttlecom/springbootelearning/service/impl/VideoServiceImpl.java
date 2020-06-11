package com.ttlecom.springbootelearning.service.impl;

import com.ttlecom.springbootelearning.entity.Course;
import com.ttlecom.springbootelearning.entity.Video;
import com.ttlecom.springbootelearning.repository.VideoRepository;
import com.ttlecom.springbootelearning.service.CourseService;
import com.ttlecom.springbootelearning.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

  private final VideoRepository videoRepository;
  private final CourseService courseService;

  public VideoServiceImpl(VideoRepository videoRepository, CourseService courseService) {
    this.videoRepository = videoRepository;
    this.courseService = courseService;
  }

  @Override
  public List<Video> getAll() {
    return videoRepository.findAll();
  }

  @Override
  public List<Video> getAllByCourseId(int id) {
    return videoRepository.getAllByCourseId(id);
  }

  @Override
  public Video getById(int id) {
    return videoRepository.findById(id).get();
  }

  @Override
  public void add(Video video) {
    videoRepository.save(video);
    Course entity = courseService.getById(video.getCourseId());
    entity.setLectureCount();
    entity.setHourCount();
    courseService.update(entity);
  }

  @Override
  public void update(Video video) {
    Video entity = videoRepository.findById(video.getId()).get();
    entity.setTitle(video.getTitle());
    entity.setTimeCount(video.getTimeCount());
    entity.setUrl(video.getUrl());
    entity.setCourseId(video.getCourseId());
    entity.setImage(video.getImage());
    videoRepository.save(entity);

    Course course = courseService.getById(video.getCourseId());
    course.setLectureCount();
    course.setHourCount();
    courseService.update(course);
  }

  @Override
  public void delete(int id) {
    videoRepository.deleteById(id);
  }

  @Override
  public void deleteByCourseId(int id) {
    videoRepository.deleteByCourseId(id);
  }
}
