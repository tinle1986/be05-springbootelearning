package com.ttlecom.springbootelearning.dto;

public class PasswordChangeDto {
  private int id;
  private String password;

  public PasswordChangeDto() {}

  public PasswordChangeDto(String password) {
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
