package com.ttlecom.springbootelearning.admin.controller;

import com.ttlecom.springbootelearning.entity.Course;
import com.ttlecom.springbootelearning.entity.Target;
import com.ttlecom.springbootelearning.service.CourseService;
import com.ttlecom.springbootelearning.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("target")
public class AdminTargetController {

  @Autowired
  private TargetService targetService;
  @Autowired
  private CourseService courseService;

  @GetMapping()
  public String index(Model model) {
    List<Target> targetList = targetService.getAll();
    model.addAttribute("targets", targetList);
    return "target/index";
  }

  @GetMapping("add")
  public String addGet(Model model) {
    List<Course> courseList = courseService.getAll();
    model.addAttribute("courses", courseList);
    model.addAttribute("target", new Target());
    return "target/add";
  }

  @PostMapping("add")
  public String addPost(Model model, @Valid @ModelAttribute("target") Target target, BindingResult errors) {
    if (target.getTitle() == null || target.getTitle().isEmpty()) {
      errors.rejectValue("title", "target", "Please input a title");
    }
    if (errors.hasErrors()) {
      List<Course> courseList = courseService.getAll();
      model.addAttribute("courses", courseList);
      return "target/add";
    }

    targetService.add(target);
    return "redirect:/target";
  }

  @GetMapping("edit")
  public String edit(@RequestParam("id") int id, Model model) {
    Target entity = targetService.getById(id);
    if (entity!= null) {
      List<Course> courseList = courseService.getAll();
      model.addAttribute("courses", courseList);
      model.addAttribute("target", entity);
    }
    return "target/edit";
  }

  @PostMapping("edit")
  public String edit(Model model, @Valid @ModelAttribute("target") Target target, BindingResult errors) {
    if (target.getTitle() == null || target.getTitle().isEmpty()) {
      errors.rejectValue("title", "target", "Please input a title");
    }
    if (errors.hasErrors()) {
      List<Course> courseList = courseService.getAll();
      model.addAttribute("courses", courseList);
      return "target/edit";
    }

    targetService.update(target);
    return "redirect:/target";
  }

  @GetMapping("delete")
  public String delete(@RequestParam("id") int id) {
    targetService.delete(id);
    return "redirect:/target";
  }
}
