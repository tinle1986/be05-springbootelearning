package com.ttlecom.springbootelearning.service;

import com.ttlecom.springbootelearning.entity.Role;

import java.util.List;

public interface RoleService {
  List<Role> getAll();

  Role getById(int id);

  void add(Role role);

  void update(Role role);

  void delete(int id);
}
