package com.ttlecom.springbootelearning.api.controller;

import com.ttlecom.springbootelearning.entity.Role;
import com.ttlecom.springbootelearning.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/role")
public class ApiRoleController {

  @Autowired
  private RoleService roleService;

  @GetMapping("")
  public ResponseEntity<? extends Object> index() {
    try {
      List<Role> roleList = roleService.getAll();
      return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>("Không lấy được dữ liệu!", HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("")
  public ResponseEntity<? extends Object> add(@RequestBody Role role) {
    try {
      roleService.add(role);
      return new ResponseEntity<String>("Added the new role successfully!", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("{id}")
  public ResponseEntity<? extends Object> update(@PathVariable int id, @RequestBody Role role) {
    try {
      role.setId(id);
      roleService.update(role);
      return new ResponseEntity<String>("Updated the role successfully!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("{id}")
  public ResponseEntity<? extends Object> delete(@PathVariable int id) {
    try {
      roleService.delete(id);
      return new ResponseEntity<String>("Deleted the role successfully!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
