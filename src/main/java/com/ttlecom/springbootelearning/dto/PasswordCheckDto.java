package com.ttlecom.springbootelearning.dto;

public class PasswordCheckDto {
  String currentPassword;

  public PasswordCheckDto() {}

  public PasswordCheckDto(String currentPassword) {
    this.currentPassword = currentPassword;
  }

  public String getCurrentPassword() {
    return currentPassword;
  }

  public void setCurrentPassword(String currentPassword) {
    this.currentPassword = currentPassword;
  }
}
