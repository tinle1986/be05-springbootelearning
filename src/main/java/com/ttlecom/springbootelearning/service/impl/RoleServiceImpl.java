package com.ttlecom.springbootelearning.service.impl;

import com.ttlecom.springbootelearning.entity.Role;
import com.ttlecom.springbootelearning.repository.RoleRepository;
import com.ttlecom.springbootelearning.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public List<Role> getAll() {
    return roleRepository.findAll();
  }

  @Override
  public Role getById(int id) {
    return roleRepository.findById(id).get();
  }

  @Override
  public void add(Role role) {
    Role entity = roleRepository.findByName(role.getName());
    if (entity == null) {
      role.setName("ROLE_" + role.getName().toUpperCase());
      roleRepository.save(role);
    } else {
      System.out.println("Role is existing!");
    }
  }

  @Override
  public void update(Role role) {
    Role entity = roleRepository.findById(role.getId()).get();
    entity.setName(role.getName().toUpperCase());
    entity.setDescription(role.getDescription());
    roleRepository.save(entity);
  }

  @Override
  public void delete(int id) {
    Role entity = roleRepository.findById(id).get();
    roleRepository.delete(entity);
  }
}
