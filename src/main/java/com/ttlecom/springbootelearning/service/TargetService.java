package com.ttlecom.springbootelearning.service;

import com.ttlecom.springbootelearning.entity.Target;

import java.util.List;

public interface TargetService {
  List<Target> getAll();

  List<Target> findByCourseId(int id);

  Target getById(int id);

  void add(Target target);

  void update(Target target);

  void delete(int id);
}
