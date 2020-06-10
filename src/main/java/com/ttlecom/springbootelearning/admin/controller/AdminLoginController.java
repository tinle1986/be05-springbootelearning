package com.ttlecom.springbootelearning.admin.controller;

import com.ttlecom.springbootelearning.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("admin/login")
public class AdminLoginController {

//  @RequestMapping(value = "", method = RequestMethod.GET)
//  public String login() {
//    return "login/index";
//  }

  @GetMapping()
  public String login(Model model) {
    model.addAttribute("login", new LoginDto());
    return "login/index";
  }

  @PostMapping()
  public String login(@ModelAttribute("login") LoginDto loginDto) {
    String uri = "http://localhost:8082/api/auth/login";
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.postForObject(uri,loginDto, String.class);
    System.out.println(result);


    return "redirect:/admin/category";
  }
}
