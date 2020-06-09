package com.ttlecom.springbootelearning.repository;

import com.ttlecom.springbootelearning.entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TargetRepository extends JpaRepository<Target, Integer> {
  List<Target> findTargetByCourseId(int id);
}
