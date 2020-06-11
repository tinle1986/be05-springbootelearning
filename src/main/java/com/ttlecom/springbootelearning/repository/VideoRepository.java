package com.ttlecom.springbootelearning.repository;

import com.ttlecom.springbootelearning.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
  void deleteByCourseId(int id);
  List<Video> getAllByCourseId(int id);
}
