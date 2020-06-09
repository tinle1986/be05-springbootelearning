package com.ttlecom.springbootelearning.admin.controller;

import com.ttlecom.springbootelearning.dto.UserDto;
import com.ttlecom.springbootelearning.entity.Role;
import com.ttlecom.springbootelearning.entity.User;
import com.ttlecom.springbootelearning.service.RoleService;
import com.ttlecom.springbootelearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("admin/user")
public class AdminUserController {

  @Autowired
  private UserService userService;
  @Autowired
  private RoleService roleService;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String index(Model model) {
    List<UserDto> users = userService.getAllDto();
    model.addAttribute("users", users);
    return "user/index";
  }

  @RequestMapping(value = "add", method = RequestMethod.GET)
  public String add(Model model) {
    List<Role> roleList = roleService.getAll();
    model.addAttribute("user", new User());
    model.addAttribute("roles", roleList);
    return "user/add";
  }

  @RequestMapping(value = "add", method = RequestMethod.POST)
  public String add(Model model, @Valid @ModelAttribute("user") User user, BindingResult errors) {
    // validate user input data
    if (user.getEmail() == null || user.getEmail().isEmpty()) {
      errors.rejectValue("email", "user", "Please input an email address");
    }
    if (user.getPassword() == null || user.getPassword().isEmpty()) {
      errors.rejectValue("password", "user", "Please input a password");
    }

    if (errors.hasErrors()) {
      List<Role> roleList = roleService.getAll();
      model.addAttribute("roles", roleList);
      return "user/add";
    }
    userService.add(user);
    return "redirect:/admin/user";
  }

  @RequestMapping(value = "edit", method = RequestMethod.GET)
  public String edit(@RequestParam("id") int id, Model model) {
    List<Role> roleList = roleService.getAll();
    User entity = userService.getById(id);
    if (entity != null) {
      model.addAttribute("roles", roleList);
      model.addAttribute("user", entity);
    }
    return "user/edit";
  }

  @RequestMapping(value = "edit", method = RequestMethod.POST)
  public String edit(Model model, @Valid @ModelAttribute("user") User user, BindingResult errors) {
    if (user.getEmail() == null || user.getEmail().isEmpty())
      errors.rejectValue("email", "user", "Please input an email address");
    if (errors.hasErrors()) {
      List<Role> roleList = roleService.getAll();
      model.addAttribute("roles", roleList);
      return "user/edit";
    }
    userService.update(user);
    return "redirect:/admin/user";
  }

  @RequestMapping(value = "password", method = RequestMethod.GET)
  public String changePassword(@RequestParam("id") int id, Model model) {
    User entity = userService.getById(id);
    if (entity != null) {
      model.addAttribute("user", entity);
    }
    return "user/password";
  }

  @RequestMapping(value = "password", method = RequestMethod.POST)
  public String changePassword(@Valid @ModelAttribute("user") User user, BindingResult errors) {
    if (user.getPassword() == null || user.getPassword().isEmpty())
      errors.rejectValue("password", "user", "Please input a password");
    if (errors.hasErrors())
      return "user/password";
    userService.updatePassword(user);
    return "redirect:/admin/user";
  }

  @RequestMapping(value = "delete", method = RequestMethod.GET)
  public String delete(@RequestParam("id") int id) {
    userService.delete(id);
    return "redirect:/admin/user";
  }
}
