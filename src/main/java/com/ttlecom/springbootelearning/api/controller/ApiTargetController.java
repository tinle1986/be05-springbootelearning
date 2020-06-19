package com.ttlecom.springbootelearning.api.controller;

import com.ttlecom.springbootelearning.entity.Target;
import com.ttlecom.springbootelearning.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/target")
public class ApiTargetController {

  @Autowired
  private TargetService targetService;

  @GetMapping("{id}")
  public ResponseEntity<?> getTargetList(@PathVariable int id) {
    try {
      List<Target> targetList = targetService.findByCourseId(id);
      return new ResponseEntity<List<Target>>(targetList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
