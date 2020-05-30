package com.ttlecom.springbootelearning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "fullname")
  @NotBlank(message = "Please input a fullname")
  private String fullname;

  @Column(name = "email")
  @Email(message = "Please input a correct email format")
  private String email;

  @Column(name = "password")
  @Length(min = 6, message = "Please input at least 6 characters")
  private String password;

  @Column(name = "avatar")
  private String avatar;

  @Column(name = "phone")
  private String phone;

  @Column(name = "role_id")
  private int roleId;

  @ManyToOne
  @JoinColumn(name = "role_id", insertable = false, updatable = false)
  @JsonIgnore
  private Role role;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  @JsonIgnore
  private List<UserCourse> userCourseList;

  public User() {
  }

  public User(int id, String fullname, String email, String password, String avatar, String phone, int roleId) {
    this.id = id;
    this.fullname = fullname;
    this.email = email;
    this.password = password;
    this.avatar = avatar;
    this.phone = phone;
    this.roleId = roleId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public List<UserCourse> getUserCourseList() {
    return userCourseList;
  }

  public void setUserCourseList(List<UserCourse> userCourseList) {
    this.userCourseList = userCourseList;
  }
}
