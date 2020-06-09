package com.ttlecom.springbootelearning.entity;

import javax.persistence.*;

@Entity
@Table(name = "targets")
public class Target {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "order_index")
  private int orderIndex;

  @Column(name = "course_id")
  private int courseId;

  @ManyToOne
  @JoinColumn(name = "course_id", insertable = false, updatable = false)
  private Course course;

  public Target() {}

  public Target(int id, String title, int orderIndex, int courseId) {
    this.id = id;
    this.title = title;
    this.orderIndex = orderIndex;
    this.courseId = courseId;
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

  public int getOrderIndex() {
    return orderIndex;
  }

  public void setOrderIndex(int orderIndex) {
    this.orderIndex = orderIndex;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }
}
