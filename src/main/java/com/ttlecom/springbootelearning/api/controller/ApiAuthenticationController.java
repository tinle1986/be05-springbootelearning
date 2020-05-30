package com.ttlecom.springbootelearning.api.controller;

import com.ttlecom.springbootelearning.dto.LoginDto;
import com.ttlecom.springbootelearning.entity.User;
import com.ttlecom.springbootelearning.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/auth")
public class ApiAuthenticationController {

  @Value("${secret-key}")
  private String secretKey;

  private final UserService userService;

  private final AuthenticationManager authenticationManager;

  public ApiAuthenticationController(UserService userService, AuthenticationManager authenticationManager) {
    this.userService = userService;
    this.authenticationManager = authenticationManager;
  }

  @PostMapping("")
  public ResponseEntity<?> signUp(@RequestBody User user) {
    try {
      userService.add(user);
      return new ResponseEntity<String>("Signed up the new user successfully!", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("login")
  public ResponseEntity<?> signIn(@RequestBody LoginDto loginDto) {
    try {
      Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
      SecurityContextHolder.getContext().setAuthentication(authentication);
      System.out.println("This is apiAuthController: " + secretKey);

      Date now = new Date();
      long EXPIRATION_TIME = 864000000L;
      String token = Jwts.builder().setSubject(loginDto.getEmail()).setIssuedAt(now).setExpiration(new Date(now.getTime() + EXPIRATION_TIME)).signWith(SignatureAlgorithm.HS512, secretKey).compact();
      return new ResponseEntity<String>(token, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
