package com.ttlecom.springbootelearning.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("course")
public class AdminCourseController {

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String index() {
    return "course/index";
  }

  @RequestMapping(value = "add", method = RequestMethod.GET)
  public String addGet() {
    return "course/add";
  }
}
