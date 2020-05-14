package com.ttlecom.springbootelearning.admin.controller;

import com.ttlecom.springbootelearning.entity.Role;
import com.ttlecom.springbootelearning.service.RoleService;
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
@RequestMapping("role")
public class AdminRoleController {

  @Autowired
  private RoleService roleService;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String index(Model model) {
    List<Role> roles = roleService.getAll();
    model.addAttribute("roles", roles);
    return "role/index";
  }

  @RequestMapping(value = "add", method = RequestMethod.GET)
  public String add(Model model) {
    model.addAttribute("role", new Role());
    return "role/add";
  }

  @RequestMapping(value = "add", method = RequestMethod.POST)
  public String add(@Valid @ModelAttribute("role") Role role, BindingResult errors) {
    if (role.getName() == null || role.getName().isEmpty()) {
      errors.rejectValue("name", "role", "Please input a role name");
    }
    if (errors.hasErrors()) {
      return "role/add";
    }
    roleService.add(role);
    return "redirect:/role/";
  }

  @RequestMapping(value = "edit", method = RequestMethod.GET)
  public String edit(@RequestParam("id") int id, Model model) {
    Role entity = roleService.getById(id);
    if (entity != null)
      model.addAttribute("role", entity);
    return "role/edit";
  }

  @RequestMapping(value = "edit", method = RequestMethod.POST)
  public String edit(@Valid @ModelAttribute("role") Role role, BindingResult errors) {
    if (role.getName() == null || role.getName().isEmpty())
      errors.rejectValue("name", "role", "Please input a role name");
    if (errors.hasErrors())
      return "role/edit";

    roleService.update(role);
    return "redirect:/role";
  }

  @RequestMapping(value = "delete", method = RequestMethod.GET)
  public String delete(@RequestParam("id") int id) {
    roleService.delete(id);
    return "redirect:/role";
  }
}
