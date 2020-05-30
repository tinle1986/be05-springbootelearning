package com.ttlecom.springbootelearning.security;

import com.ttlecom.springbootelearning.entity.User;
import com.ttlecom.springbootelearning.repository.UserRepository;
import com.ttlecom.springbootelearning.service.CustomUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

  private final UserRepository userRepository;

  public CustomUserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User entity = userRepository.findByEmail(email);
    if (entity == null) throw new UsernameNotFoundException("Email not found!");

    String roleName = entity.getRole().getName();
    List<GrantedAuthority> authorityList = new ArrayList<>();
    authorityList.add(new SimpleGrantedAuthority(roleName));

    return new CustomUserDetails(email, entity.getPassword(), authorityList);
  }
}
