package com.ttlecom.springbootelearning.dto;

public class UserDto {
  private int id;
  private String fullname;
  private String email;
  private String phone;
  private String roleName;

  public UserDto() {}

  public UserDto(int id, String fullname, String email, String phone, String roleName) {
    this.id = id;
    this.fullname = fullname;
    this.email = email;
    this.phone = phone;
    this.roleName = roleName;
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
}
