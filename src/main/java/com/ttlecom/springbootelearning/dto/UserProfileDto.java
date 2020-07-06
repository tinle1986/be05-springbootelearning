package com.ttlecom.springbootelearning.dto;

public class UserProfileDto {
  private String email;
  private String fullname;
  private String phone;
  private String avatar;

  public UserProfileDto() {}

  public UserProfileDto(String email, String fullname, String phone, String avatar) {
    this.email = email;
    this.fullname = fullname;
    this.phone = phone;
    this.avatar = avatar;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
