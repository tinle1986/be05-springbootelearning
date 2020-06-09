package com.ttlecom.springbootelearning.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin/login")
public class AdminLoginController {

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String login() {
    return "login/index";
  }
}
