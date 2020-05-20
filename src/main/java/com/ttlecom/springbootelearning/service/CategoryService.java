package com.ttlecom.springbootelearning.service;

import com.ttlecom.springbootelearning.entity.Category;

import java.util.List;

public interface CategoryService {
  List<Category> getAll();

  Category getById(int id);

  void add(Category category);

  void update(Category category);

  void delete(int id);
}
