package com.ttlecom.springbootelearning.service.impl;

import com.ttlecom.springbootelearning.dto.UserDto;
import com.ttlecom.springbootelearning.entity.User;
import com.ttlecom.springbootelearning.repository.UserRepository;
import com.ttlecom.springbootelearning.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getAll() {
    return userRepository.findAll();
  }

  @Override
  public User getById(int id) {
    return userRepository.findById(id).get();
  }

  @Override
  public User getByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public void add(User user) {
    // check user duplicate by email instead of id
    User entity = userRepository.findByEmail(user.getEmail());
    if (entity == null) {
      // hash the password
      String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
      // set password hashed
      user.setPassword(hashed);
      userRepository.save(user);
    } else {
      System.out.println("Email is existing!");
    }
  }

  @Override
  public void update(User user) {
    User entity = userRepository.findById(user.getId()).get();
    entity.setPhone(user.getPhone());
    entity.setFullname(user.getFullname());
    entity.setEmail(user.getEmail());
    entity.setAvatar(user.getAvatar());
    entity.setRoleId(user.getRoleId());
//      entity.setPassword(user.getPassword());
    userRepository.save(entity);
  }

  @Override
  public void delete(int id) {
    User entity = userRepository.findById(id).get();
    userRepository.delete(entity);
  }

  @Override
  public List<UserDto> getAllDto() {
    return userRepository.getAll();
  }

  @Override
  public void updatePassword(User user) {
    User entity = userRepository.findByEmail(user.getEmail());
    if (entity != null) {
      String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
      entity.setPassword(hashed);
      userRepository.save(entity);
    }
  }
}
