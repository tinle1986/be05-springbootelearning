package com.ttlecom.springbootelearning.admin.controller;

import com.ttlecom.springbootelearning.entity.Category;
import com.ttlecom.springbootelearning.entity.Course;
import com.ttlecom.springbootelearning.service.CategoryService;
import com.ttlecom.springbootelearning.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("admin/course")
public class AdminCourseController {

  private final CourseService courseService;
  private final CategoryService categoryService;

  public AdminCourseController(CourseService courseService, CategoryService categoryService) {
    this.courseService = courseService;
    this.categoryService = categoryService;
  }

  @GetMapping("")
  public String index(Model model) {
    List<Course> courseList = courseService.getAll();
    model.addAttribute("courses", courseList);
//    getCategories();
    return "course/index";
  }

  @GetMapping("add")
  public String addGet(Model model) {
    List<Category> categoryList = categoryService.getAll();
    model.addAttribute("course", new Course());
    model.addAttribute("categories", categoryList);
    return "course/add";
  }

  @PostMapping("add")
  public String addPost(Model model, @Valid @ModelAttribute("course") Course course, BindingResult errors) {

    // going to validate following fields
    // 1. title
    // 2. lectureCount -> skip
    // 3. hourCount -> skip
    // 4. price -> skip
    // 5. discount -> skip
    // 6. description
    // 7. content

    if (course.getTitle() == null || course.getTitle().isEmpty()) {
      errors.rejectValue("title", "course", "Please input a title");
    }
    if (course.getDescription() == null || course.getDescription().isEmpty()) {
      errors.rejectValue("description", "course", "Please input a description");
    }
    if (course.getContent() == null || course.getContent().isEmpty()) {
      errors.rejectValue("content", "course", "Please input a gist");
    }
    if (course.getImage() == null || course.getImage().isEmpty()) {
      course.setImage("/assets/images/1.png");
    }

    /*if (course.getLectureCount() == null) {
//      errors.rejectValue("lectureCount", "course", "Please input a number");
      course.setLectureCount(0);
    }*/

    if (errors.hasErrors()) {
      List<Category> categoryList = categoryService.getAll();
      model.addAttribute("categories", categoryList);
      return "course/add";
    }

    courseService.add(course);
    return "redirect:/admin/course";
  }

  @GetMapping("edit")
  public String edit(@RequestParam("id") int id, Model model) {
    List<Category> categoryList = categoryService.getAll();
    Course entity = courseService.getById(id);
    if (entity != null) {
      model.addAttribute("course", entity);
      model.addAttribute("categories", categoryList);
    }
    return "course/edit";
  }

  @PostMapping("edit")
  public String edit(Model model, @Valid @ModelAttribute("course") Course course, BindingResult errors) {

    if (course.getTitle() == null || course.getTitle().isEmpty()) {
      errors.rejectValue("title", "course", "Please input a title");
    }
    if (course.getDescription() == null || course.getDescription().isEmpty()) {
      errors.rejectValue("description", "course", "Please input a description");
    }
    if (course.getContent() == null || course.getContent().isEmpty()) {
      errors.rejectValue("content", "course", "Please input a gist");
    }
    if (course.getImage() == null || course.getImage().isEmpty()) {
      course.setImage("/assets/images/1.png");
    }

    /*if (course.getLectureCount() == null) {
      course.setLectureCount(0);
    }*/

    if (errors.hasErrors()) {
      List<Category> categoryList = categoryService.getAll();
      model.addAttribute("categories", categoryList);
      return "course/edit";
    }

    courseService.update(course);
    return "redirect:/admin/course";
  }

  @GetMapping("delete")
  public String delete(@RequestParam("id") int id) {
    courseService.delete(id);
    return "redirect:/admin/course";
  }
}
