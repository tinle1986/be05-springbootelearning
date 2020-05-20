package com.ttlecom.springbootelearning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "icon")
  private String icon;

  @Column(name = "order_index")
  private int orderIndex;

  @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
  @JsonIgnore
  private List<Course> courseList;

  public Category() {}

  public Category(int id, String title, String icon, int orderIndex) {
    this.id = id;
    this.title = title;
    this.icon = icon;
    this.orderIndex = orderIndex;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public int getOrderIndex() {
    return orderIndex;
  }

  public void setOrderIndex(int orderIndex) {
    this.orderIndex = orderIndex;
  }

  public List<Course> getCourseList() {
    return courseList;
  }

  public void setCourseList(List<Course> courseList) {
    this.courseList = courseList;
  }


}
