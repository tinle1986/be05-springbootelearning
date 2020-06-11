package com.ttlecom.springbootelearning.api.controller;

import com.ttlecom.springbootelearning.dto.*;
import com.ttlecom.springbootelearning.entity.User;
import com.ttlecom.springbootelearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class ApiUserController {

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  //  get user profile info
  @GetMapping("")
  public ResponseEntity<?> profile() {
    try {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = (UserDetails) principal;
      String email = userDetails.getUsername();
      User entity = userService.getByEmail(email);
      return new ResponseEntity<User>(entity, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
    }
  }

  // get user dto profile
  @GetMapping("role")
  public ResponseEntity<?> roleProfile() {
    try {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = (UserDetails) principal;
      String email = userDetails.getUsername();
      User entity = userService.getByEmail(email);
      UserDto userDto = userService.findByEmailAndRoleId(email, entity.getRoleId());
      return new ResponseEntity<String>(userDto.getRoleName(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  //  get user list
  @GetMapping("list")
  public ResponseEntity<?> index() {
    try {
      List<UserDto> userList = userService.getAllDto();
      return new ResponseEntity<List<UserDto>>(userList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  //  change avatar
  @PutMapping("avatar")
  public ResponseEntity<?> updateAvatar(@RequestBody AvatarChangeDto avatarChangeDto) {
    try {
      User entity = userService.getByEmail(avatarChangeDto.getEmail());
      entity.setAvatar(avatarChangeDto.getUrl());
      userService.update(entity);
      return new ResponseEntity<String>("Updated the avatar successfully!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  //  get avatar url
  @GetMapping("avatar")
  public ResponseEntity<?> getAvatarUrl() {
    try {
      // get userDetails đang có sẵn trong SecurityContext -> trích xuất email và tìm avatar đang có của user
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = (UserDetails) principal;
      String email = userDetails.getUsername();
      User entity = userService.getByEmail(email);
      String imgUrl = entity.getAvatar();
      if (imgUrl == null) imgUrl = "";
      return new ResponseEntity<String>(imgUrl, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  // update user profile info v1
  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  public ResponseEntity<?> update(@PathVariable int id, @RequestBody User user) {
    try {
      user.setId(id);
      userService.update(user);
      return new ResponseEntity<String>("Updated the user successfully!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  //  update user profile info v2
  @PutMapping("")
  public ResponseEntity<?> updateUserProfile(@RequestBody UserProfileDto userProfileDto) {
    try {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = (UserDetails) principal;
      String email = userDetails.getUsername();
      User entity = userService.getByEmail(email);
      entity.setEmail(userProfileDto.getEmail());
      entity.setFullname(userProfileDto.getFullname());
      entity.setPhone(userProfileDto.getPhone());
      userService.update(entity);
      return new ResponseEntity<String>("Updated the user profile successfully!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  //  @RequestMapping(value = "password/{id}", method = RequestMethod.PUT)
  @PutMapping("password")
  public ResponseEntity<?> changePassword(@RequestBody PasswordChangeDto passwordChangeDto) {
    try {
      User entity = userService.getByEmail(passwordChangeDto.getEmail());
      entity.setPassword(passwordChangeDto.getPassword());
      userService.updatePassword(entity);
      return new ResponseEntity<String>("Updated the password successfully!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  // check password matched, return true or false
  @PostMapping("password")
  public ResponseEntity<?> checkPasswordMatch(@RequestBody PasswordCheckDto passwordCheckDto) {
    try {
      String currentPassword = passwordCheckDto.getCurrentPassword();
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = (UserDetails) principal;
      String email = userDetails.getUsername();
      User entity = userService.getByEmail(email);
      String encodedPassword = entity.getPassword();
      Boolean result = passwordEncoder.matches(currentPassword, encodedPassword);
      return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public ResponseEntity<?> delete(@PathVariable int id) {
    try {
      userService.delete(id);
      return new ResponseEntity<String>("Deleted the user successfully!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
