package com.ttlecom.springbootelearning.service.impl;

import com.ttlecom.springbootelearning.entity.Category;
import com.ttlecom.springbootelearning.repository.CategoryRepository;
import com.ttlecom.springbootelearning.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> getAll() {
    return categoryRepository.findAll();
  }

  @Override
  public Category getById(int id) {
    return categoryRepository.findById(id).get();
  }

  @Override
  public void add(Category category) {
    Category entity = categoryRepository.findByTitle(category.getTitle());
    if (entity == null) {
      category.setTitle(category.getTitle().toLowerCase());
      categoryRepository.save(category);
    } else {
      System.out.println("The category is existing!");
    }
  }

  @Override
  public void update(Category category) {
    Category entity = categoryRepository.findById(category.getId()).get();
    entity.setIcon(category.getIcon());
    entity.setOrderIndex(category.getOrderIndex());
    entity.setTitle(category.getTitle().toLowerCase());
    categoryRepository.save(entity);
  }

  @Override
  public void delete(int id) {
    categoryRepository.deleteById(id);
  }
}
