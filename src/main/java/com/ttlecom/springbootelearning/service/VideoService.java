package com.ttlecom.springbootelearning.service;

import com.ttlecom.springbootelearning.entity.Video;

import java.util.List;

public interface VideoService {
  List<Video> getAll();
  List<Video> getAllByCourseId(int id);

  Video getById(int id);

  void add(Video video);

  void update(Video video);

  void delete(int id);

  void deleteByCourseId(int id);
}
