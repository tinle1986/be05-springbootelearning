package com.ttlecom.springbootelearning.service;

import com.ttlecom.springbootelearning.dto.UserDto;
import com.ttlecom.springbootelearning.entity.User;

import java.util.List;

public interface UserService {
  List<User> getAll();

  User getById(int id);

  User getByEmail(String email);

  void add(User user);

  void update(User user);

  void delete(int id);

  List<UserDto> getAllDto();

  void updatePassword(User user);
}
