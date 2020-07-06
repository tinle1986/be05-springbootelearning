package com.ttlecom.springbootelearning.dto;

public class GetCoursesByCategoryIdDto {
  private int categoryId;

  public GetCoursesByCategoryIdDto() {}

  public GetCoursesByCategoryIdDto(int categoryId) {
    this.categoryId = categoryId;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }
}
