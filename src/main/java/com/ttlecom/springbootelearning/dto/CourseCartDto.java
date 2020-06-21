package com.ttlecom.springbootelearning.dto;

import java.util.List;

public class CourseCartDto {
  private List<Integer> cartList;

  public CourseCartDto() {
  }

  public CourseCartDto(List<Integer> cartList) {
    this.cartList = cartList;
  }

  public List<Integer> getCartList() {
    return cartList;
  }

  public void setCartList(List<Integer> cartList) {
    this.cartList = cartList;
  }
}
