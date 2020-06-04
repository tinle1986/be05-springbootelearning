package com.ttlecom.springbootelearning.admin.controller;

import com.ttlecom.springbootelearning.entity.Category;
import com.ttlecom.springbootelearning.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("category")
public class AdminCategoryController {

  private final CategoryService categoryService;

  public AdminCategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("")
  public String index(Model model) {
    List<Category> categoryList = categoryService.getAll();
    model.addAttribute("categories", categoryList);
    return "category/index";
  }

  @GetMapping("add")
  public String addGet(Model model) {
    model.addAttribute("category", new Category());
    return "category/add";
  }

  @PostMapping("add")
  public String addPost(@Valid @ModelAttribute("category") Category category, BindingResult errors) {
    if (category.getTitle() == null || category.getTitle().isEmpty()) {
      errors.rejectValue("title", "category", "Please input a title");
    }
    if (category.getIcon() == null || category.getIcon().isEmpty()) {
      errors.rejectValue("icon", "category", "Please input an icon");
    }

    if (errors.hasErrors()) {
      return "category/add";
    }

    categoryService.add(category);
    return "redirect:/category";
  }

  @GetMapping("edit")
  public String edit(@RequestParam("id") int id, Model model) {
    Category entity = categoryService.getById(id);
    if (entity != null) {
      model.addAttribute("category", entity);
    }
    return "category/edit";
  }

  @PostMapping("edit")
  public String edit(@Valid @ModelAttribute("category") Category category, BindingResult errors) {
    if (category.getTitle() == null || category.getTitle().isEmpty()) {
      errors.rejectValue("title", "category", "Please input a title");
    }
    if (category.getIcon() == null || category.getIcon().isEmpty()) {
      errors.rejectValue("icon", "category", "Please input an icon");
    }

    if (errors.hasErrors()) {
      return "category/edit";
    }

    categoryService.update(category);
    return "redirect:/category";
  }

  @GetMapping("delete")
  public String delete(@RequestParam("id") int id) {
    categoryService.delete(id);
    return "redirect:/category";
  }
}
