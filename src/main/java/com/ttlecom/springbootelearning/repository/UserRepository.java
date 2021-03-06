package com.ttlecom.springbootelearning.repository;

import com.ttlecom.springbootelearning.dto.UserDto;
import com.ttlecom.springbootelearning.dto.UserProfileDto;
import com.ttlecom.springbootelearning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByEmail(String email);

  List<User> findByEmailOrFullname(String email, String fullname);

  // u is alias of class User -> for this kind of query annotation
  // must use the class name (not the table name)
  // @Query("SELECT u FROM User u")
  @Query("SELECT new com.ttlecom.springbootelearning.dto.UserDto(u.id, u.email, u.fullname, u.phone, r.name) FROM User u JOIN u.role r")
  List<UserDto> getAll();

  @Query("SELECT new com.ttlecom.springbootelearning.dto.UserDto(u.id, u.email, u.fullname, u.phone, r.name) FROM User u JOIN u.role r WHERE u.email = ?1 AND u.roleId = ?2")
  UserDto findByEmailAndRoleId(String email, int roleId);

  @Query("SELECT new com.ttlecom.springbootelearning.dto.UserProfileDto(u.email, u.fullname, u.phone, u.avatar) FROM User u WHERE u.email = ?1")
  UserProfileDto findUserProfileByEmail(String email);
}
