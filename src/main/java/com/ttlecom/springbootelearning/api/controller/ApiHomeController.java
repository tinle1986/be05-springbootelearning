package com.ttlecom.springbootelearning.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/home")
public class ApiHomeController {

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String index() {
    return "home/index";
  }
}
