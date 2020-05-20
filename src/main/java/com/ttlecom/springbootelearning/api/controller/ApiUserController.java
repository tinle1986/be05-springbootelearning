package com.ttlecom.springbootelearning.api.controller;

import com.ttlecom.springbootelearning.dto.LoginDto;
import com.ttlecom.springbootelearning.dto.PasswordChangeDto;
import com.ttlecom.springbootelearning.dto.UserDto;
import com.ttlecom.springbootelearning.entity.User;
import com.ttlecom.springbootelearning.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class ApiUserController {

  private final long EXPIRATION_TIME = 864000000L;
  private final String MY_SECRET_KEY = "123456";

  @Autowired
  private UserService userService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<? extends Object> index() {
    try {
      List<UserDto> userList = userService.getAllDto();
      return new ResponseEntity<List<UserDto>>(userList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("")
  @CrossOrigin
  public ResponseEntity<? extends Object> signUp(@RequestBody User user) {
    try {
      userService.add(user);
      return new ResponseEntity<String>("Signed up the new user successfully!", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("login")
  @CrossOrigin
  public ResponseEntity<? extends Object> signIn(@RequestBody LoginDto loginDto) {
    try {
      Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
      SecurityContextHolder.getContext().setAuthentication(authentication);

      Date now = new Date();
      String token = Jwts.builder().setSubject(loginDto.getEmail()).setIssuedAt(now).setExpiration(new Date(now.getTime() + EXPIRATION_TIME)).signWith(SignatureAlgorithm.HS512, MY_SECRET_KEY).compact();
      return new ResponseEntity<String>(token, HttpStatus.OK);
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
