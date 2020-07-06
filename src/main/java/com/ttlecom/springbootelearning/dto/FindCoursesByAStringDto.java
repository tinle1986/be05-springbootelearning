package com.ttlecom.springbootelearning.dto;

public class FindCoursesByAStringDto {
  private String titleString;

  public FindCoursesByAStringDto() {}

  public FindCoursesByAStringDto(String titleString) {
    this.titleString = titleString;
  }

  public String getTitleString() {
    return titleString;
  }

  public void setTitleString(String titleString) {
    this.titleString = titleString;
  }
}
