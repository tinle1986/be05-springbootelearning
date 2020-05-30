package com.ttlecom.springbootelearning.dto;

public class AvatarChangeDto {
  private String email;
  private String url;

  public AvatarChangeDto() {}

  public AvatarChangeDto(String email, String url) {
    this.email = email;
    this.url = url;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
