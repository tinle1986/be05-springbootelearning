package com.ttlecom.springbootelearning.api.controller;

import com.ttlecom.springbootelearning.entity.Category;
import com.ttlecom.springbootelearning.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class ApiCategoryController {

  @Autowired
  private CategoryService categoryService;

  @GetMapping("")
  @CrossOrigin
  public ResponseEntity<? extends Object> index() {
    try {
      List<Category> categoryList = categoryService.getAll();
      return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("")
  public ResponseEntity<? extends Object> add(@RequestBody Category category) {
    try {
      categoryService.add(category);
      return new ResponseEntity<String>("Created the category successfully!", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(value = "{id}")
  public ResponseEntity<? extends Object> update(@PathVariable int id, @RequestBody Category category) {
    try {
      category.setId(id);
      categoryService.update(category);
      return new ResponseEntity<String>("Update the category successfully!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping(value = "{id}")
  public ResponseEntity<? extends Object> delete(@PathVariable int id) {
    try {
      categoryService.delete(id);
      return new ResponseEntity<String>("Deleted the category successfully!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
