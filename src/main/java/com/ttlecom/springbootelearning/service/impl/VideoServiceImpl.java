package com.ttlecom.springbootelearning.service.impl;

import com.ttlecom.springbootelearning.entity.Video;
import com.ttlecom.springbootelearning.repository.VideoRepository;
import com.ttlecom.springbootelearning.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

  private final VideoRepository videoRepository;

  public VideoServiceImpl(VideoRepository videoRepository) {
    this.videoRepository = videoRepository;
  }

  @Override
  public List<Video> getAll() {
    return videoRepository.findAll();
  }

  @Override
  public Video getById(int id) {
    return videoRepository.findById(id).get();
  }

  @Override
  public void add(Video video) {
    videoRepository.save(video);
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
  }

  @Override
  public void delete(int id) {
    videoRepository.deleteById(id);
  }
}
