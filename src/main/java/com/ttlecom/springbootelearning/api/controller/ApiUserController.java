package com.ttlecom.springbootelearning.api.controller;

import com.ttlecom.springbootelearning.dto.PasswordChangeDto;
import com.ttlecom.springbootelearning.dto.UserDto;
import com.ttlecom.springbootelearning.entity.User;
import com.ttlecom.springbootelearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class ApiUserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<? extends Object> index() {
    try {
      List<UserDto> userList = userService.getAllDto();
      return new ResponseEntity<List<UserDto>>(userList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<? extends Object> add(@RequestBody User user) {
    try {
      userService.add(user);
      return new ResponseEntity<String>("Added the new user successfully!", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  public ResponseEntity<? extends Object> update(@PathVariable int id, @RequestBody User user) {
    try {
      user.setId(id);
      userService.update(user);
      return new ResponseEntity<String>("Updated the user successfully!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "password/{id}", method = RequestMethod.PUT)
  public ResponseEntity<? extends Object> password(@PathVariable int id, @RequestBody PasswordChangeDto passwordChangeDto) {
    try {
      User entity = userService.getById(id);
      entity.setPassword(passwordChangeDto.getPassword());
      userService.updatePassword(entity);
      return new ResponseEntity<String>("Updated the password successfully!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public ResponseEntity<? extends Object> delete(@PathVariable int id) {
    try {
      userService.delete(id);
      return new ResponseEntity<String>("Deleted the user successfully!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
