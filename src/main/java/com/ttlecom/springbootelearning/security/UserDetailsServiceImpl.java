package com.ttlecom.springbootelearning.security;

import com.ttlecom.springbootelearning.entity.User;
import com.ttlecom.springbootelearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User entity = userRepository.findByEmail(email);
    if (entity == null) throw new UsernameNotFoundException("Email not found!");

    String roleName = entity.getRole().getName();
    List<GrantedAuthority> authorityList = new ArrayList<>();
    authorityList.add(new SimpleGrantedAuthority(roleName));

    CustomUserDetails userDetails = new CustomUserDetails(email, entity.getPassword(), authorityList);

    return userDetails;
  }
}
